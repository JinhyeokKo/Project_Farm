# 스크린캡쳐 안드로이드 애플리케이션

실시간으로 사용자의 스마트폰 화면을 캡처하여 서버로 전송하는 안드로이드 애플리케이션입니다.
My-Farm 프로젝트의 딥러닝 모델에 전송할 실제 서비스 단계에서 사용할 목적으로 구현되었습니다.

## 주요 기능

- 실시간 화면 캡처
- Base64 인코딩을 통한 이미지 전송
- 백그라운드 서비스 실행
- 자동 재시도 메커니즘
- 주기적 캡처 (1분 간격)

## 기술 스택

- **Language**: Kotlin
- **Network**: OkHttp3
- **Media**: Android MediaProjection API
- **Architecture**: Service-based background processing

## 구조

### MainActivity
- 화면 캡처 권한 요청 및 관리
- MediaProjection 설정
- VirtualDisplay 생성
- ImageReader를 통한 화면 캡처
- ScheduledExecutorService를 통한 주기적 실행

### ScreenCaptureService
- 백그라운드에서 지속적인 화면 캡처 지원
- Foreground Service로 동작하여 앱이 백그라운드에서도 실행 유지

## 주요 메소드

### startScreenCapture()
화면 캡처 권한을 요청하고 Foreground Service를 시작합니다.

### captureScreen()
현재 화면을 캡처하여 Bitmap으로 변환한 후 Base64 인코딩을 수행합니다.

### sendImageToServer()
캡처된 이미지를 Base64 문자열로 변환하여 지정된 서버로 전송합니다.

## 권한

- `WRITE_EXTERNAL_STORAGE`: 캡처된 이미지 저장
- `FOREGROUND_SERVICE`: 백그라운드 서비스 실행
- `MediaProjection`: 화면 캡처

## 이미지 처리

- 화면 캡처 형식: RGBA_8888
- 출력 형식: PNG
- 전송 형식: Base64 인코딩된 문자열

## 네트워크 설정

- 연결 타임아웃: 50초
- 읽기 타임아웃: 50초
- 쓰기 타임아웃: 50초
- 실패 시 1분 후 자동 재시도

## 서버 연동

- 메소드: POST
- 컨텐츠 타입: text/plain
- 페이로드: Base64 인코딩된 이미지 문자열

## 주의사항

- Android 6.0 이상에서는 런타임 권한 요청이 필요합니다
- 화면 캡처는 사용자의 명시적인 동의가 필요합니다
- 백그라운드 실행을 위해 Foreground Service를 사용합니다
