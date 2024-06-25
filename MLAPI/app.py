# from flask import Flask, request, jsonify
# from PIL import Image
# import io
# import torch
# import torchvision.transforms as transforms
#
# app = Flask(__name__)
#
# # 모델 로드 (여기에 실제 모델 경로를 사용)
# model = torch.load('path_to_model.pth')
# model.eval()  # 모델을 평가 모드로 설정
#
#
# # 이미지 전처리 함수(학습시킨 모델에 맞게 설정)
# def transform_image(image_bytes):
#     transform = transforms.Compose([
#         transforms.Resize((224, 224)),  # 이미지 크기를 224x224로 조정
#         transforms.ToTensor(),  # 이미지를 텐서로 변환
#         transforms.Normalize([0.485, 0.456, 0.406], [0.229, 0.224, 0.225])  # 이미지 정규화
#     ])
#     image = Image.open(io.BytesIO(image_bytes))  # byte 데이터를 이미지로 변환
#     return transform(image).unsqueeze(0)  # 모델 입력에 맞게 배치 차원 추가
#
#
# @app.route('/predict', methods=['POST'])
# def predict():
#     if 'file' not in request.files:
#         return jsonify({'error': 'No file part in the request'}), 400  # 파일이 없으면 에러 반환
#
#     file = request.files['file']
#     if file.filename == '':
#         return jsonify({'error': 'No selected file'}), 400  # 파일명이 없으면 에러 반환
#
#     try:
#         image_bytes = file.read()  # 파일 내용을 읽음
#         tensor = transform_image(image_bytes)  # 이미지를 전처리하여 텐서로 변환
#         with torch.no_grad():  # 예측 시에는 gradient 계산을 비활성화
#             outputs = model(tensor)  # 모델 예측 수행
#         _, predicted = outputs.max(1)  # 가장 높은 확률을 가진 클래스 선택
#         return jsonify({'prediction': predicted.item()})  # 예측 결과 반환
#     except Exception as e:
#         return jsonify({'error': str(e)}), 500  # 오류가 발생한 경우 에러 메시지 반환
#
#
# if __name__ == '__main__':
#     app.run(debug=True)  # Flask 서버 실행

## 통신 테스트용 코드
from flask import Flask, request, jsonify

app = Flask(__name__)

@app.route('/predict', methods=['POST'])
def predict():
    if 'file' not in request.files:
        return jsonify({'error': 'No file part in the request'}), 400 # 파일이 없으면 에러 반환

    file = request.files['file']
    if file.filename == '':
        return jsonify({'error': 'No selected file'}), 400 # 파일명이 없으면 에러 반환

    # 모델이 없으므로 간단히 예측 결과를 반환
    return jsonify({'prediction': 'No model available for prediction'}), 200

if __name__ == '__main__':
    app.run(debug=True)
