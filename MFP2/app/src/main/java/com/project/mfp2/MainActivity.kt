package com.project.mfp2

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.PixelFormat
import android.hardware.display.DisplayManager
import android.hardware.display.VirtualDisplay
import android.media.Image
import android.media.ImageReader
import android.media.projection.MediaProjection
import android.media.projection.MediaProjectionManager
import android.os.Build
import android.os.Bundle
import android.util.Base64
import android.util.DisplayMetrics
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.nio.ByteBuffer
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    private lateinit var mediaProjectionManager: MediaProjectionManager
    private var mediaProjection: MediaProjection? = null
    private var virtualDisplay: VirtualDisplay? = null
    private var imageReader: ImageReader? = null
    private val storagePermissionRequestCode = 1
    private val scheduledExecutor: ScheduledExecutorService = Executors.newSingleThreadScheduledExecutor()

    // 미디어 프로젝션 요청 런처
    private val mediaProjectionLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            val intent = result.data
            mediaProjection = mediaProjectionManager.getMediaProjection(result.resultCode, intent!!)
            startCapture()
        } else {
            Log.e("ScreenCapture", "Screen capture permission denied")
            showToast("Screen capture permission denied")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mediaProjectionManager = getSystemService(Context.MEDIA_PROJECTION_SERVICE) as MediaProjectionManager

        // 저장소 권한 확인
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            requestStoragePermission()
        } else {
            startScreenCapture()
        }
    }

    // 저장소 권한 요청
    @SuppressLint("ObsoleteSdkInt")
    private fun requestStoragePermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (shouldShowRequestPermissionRationale(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                // 이전에 권한 거부를 선택한 경우
                showPermissionRationaleDialog()
            } else {
                // 처음 권한 요청하는 경우
                requestPermissions(arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), storagePermissionRequestCode)
            }
        } else {
            // Android 6.0 미만 버전에서는 권한 요청 없이 바로 허용
            startScreenCapture()
        }
    }

    // 권한 요청 결과 처리
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == storagePermissionRequestCode) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Log.d("ScreenCapture", "저장소 권한이 허용되었습니다.")
                startScreenCapture()
            } else {
                Log.e("ScreenCapture", "저장소 권한이 거부되었습니다.")
            }
        }
    }

    // 권한이 필요한 이유를 설명하는 대화상자 표시
    @SuppressLint("ObsoleteSdkInt")
    private fun showPermissionRationaleDialog() {
        AlertDialog.Builder(this)
            .setTitle("저장소 권한 필요")
            .setMessage("스크린샷을 저장하기 위해 저장소 권한이 필요합니다.")
            .setPositiveButton("허용") { _, _ ->
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    requestPermissions(arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), storagePermissionRequestCode)
                } else {
                    startScreenCapture()
                }
            }
            .setNegativeButton("거부") { _, _ -> }
            .show()
    }

    // 화면 캡처 시작
    private fun startScreenCapture() {
        val intent = mediaProjectionManager.createScreenCaptureIntent()
        mediaProjectionLauncher.launch(intent)

        val serviceIntent = Intent(this, ScreenCaptureService::class.java)
        ContextCompat.startForegroundService(this, serviceIntent)
    }

    // 캡처 시작
    private fun startCapture() {
        val metrics = DisplayMetrics().also { windowManager.defaultDisplay.getMetrics(it) }
        val density = metrics.densityDpi
        val width = metrics.widthPixels
        val height = metrics.heightPixels

        // 변경사항: PixelFormat.RGBA_8888로 변경
        imageReader = ImageReader.newInstance(width, height, PixelFormat.RGBA_8888, 2)

        virtualDisplay = mediaProjection?.createVirtualDisplay(
            "ScreenCapture",
            width, height, density,
            DisplayManager.VIRTUAL_DISPLAY_FLAG_AUTO_MIRROR,
            imageReader?.surface, null, null
        )

        scheduledExecutor.scheduleAtFixedRate({
            captureScreen()
        }, 1, 1, TimeUnit.MINUTES)
    }

    // 화면 캡처
    private fun captureScreen() {
        val image = imageReader?.acquireLatestImage()

        if (image != null) {
            // 변경사항: 이미지 데이터를 RGBA_8888 형식으로 변환하여 Bitmap 생성
            val planes = image.planes
            val buffer = planes[0].buffer
            val pixelStride = planes[0].pixelStride
            val rowStride = planes[0].rowStride
            val rowPadding = rowStride - pixelStride * image.width
            val bitmap = Bitmap.createBitmap(image.width + rowPadding / pixelStride, image.height, Bitmap.Config.ARGB_8888)
            bitmap.copyPixelsFromBuffer(buffer)

            image.close()

            val outputStream = ByteArrayOutputStream()
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream)
            val byteArray = outputStream.toByteArray()
            val base64String: String = Base64.encodeToString(byteArray, Base64.NO_WRAP)

            Log.d("ScreenCapture", "화면 캡처가 완료되었습니다.")
            sendImageToServer(base64String)
        } else {
            Log.e("ScreenCapture", "캡처된 이미지가 null입니다.")
        }
    }

    // 서버로 이미지 전송
    private fun sendImageToServer(base64String: String) {
        val client = OkHttpClient.Builder()
            .connectTimeout(50, TimeUnit.SECONDS)
            .readTimeout(50, TimeUnit.SECONDS)
            .writeTimeout(50, TimeUnit.SECONDS)
            .build()

        // Base64 인코딩 옵션 수정
//        val encodedString = Base64.encodeToString(base64String.toByteArray(), Base64.NO_WRAP)
        val requestBody = base64String.toRequestBody("text/plain".toMediaTypeOrNull())

        // EC2 인스턴스의 퍼블릭 IP 주소로 변경
        val serverUrl = "http://3.39.129.49:8080/upload"

        val request = Request.Builder()
            .url(serverUrl)
            .post(requestBody)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e("ScreenCapture", "서버로 이미지 전송에 실패했습니다: ${e.message}")
                // 재시도 로직 추가
                scheduledExecutor.schedule({
                    sendImageToServer(base64String)
                }, 1, TimeUnit.MINUTES)
            }

            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful) {
                    Log.d("ScreenCapture", "서버로 이미지를 성공적으로 전송했습니다.")
                } else {
                    Log.e("ScreenCapture", "서버로 이미지 전송에 실패했습니다: ${response.message}")
                }
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        stopCapture()

        val serviceIntent = Intent(this, ScreenCaptureService::class.java)
        stopService(serviceIntent)
    }

    // 캡처 중지
    private fun stopCapture() {
        virtualDisplay?.release()
        mediaProjection?.stop()
        scheduledExecutor.shutdown()
    }

    // Toast 메시지 표시
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}