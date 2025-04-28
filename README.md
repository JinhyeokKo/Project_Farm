# 제 9회 농림축산식품부 공공데이터 활용 창업경진대회
![logo](https://raw.githubusercontent.com/JinhyeokKo/Project_Farm/master/docs/logo.jpg)
* 공모 구분 : 아이디어 기획(공공데이터) 제품 및 서비스 개발 부문 작품 공모
* 공모 내용 : 식품 분야 생산, 유통, 소비 관련 국민편익 제고 및 부가가치 창출을 위한 web 및 app 서비스
* 대회 기간
    * ~ 7.1 : 제출 마감
    * ~ 7.9 : 서류 심사
    * 7.29 ~ 7.30 발표 심사

## 프로젝트 소개
* AI를 활용한 힐링 및 감성 서비스로, 사용자가 교환일기를 작성하면 다음 접속 시 AI가 답글을 제공하여 소통의 느낌을 줍니다. 또한, 스트리밍 시청 중 채팅 기능을 통해 마치 화훼작물과 대화하는 듯한 경험을 선사합니다.
* 첫 사용 시에는 사용자의 선호도를 기반으로 적절한 화훼작물을 추천해 주며, 추천 작물 이외에 사용자가 원하는 작물을 선택할 수도 있습니다. 앨범 기능도 지원하여, 하루에 한 컷씩 사진을 찍어 저장하고, 화훼가 다 자랐을 때 재배 전까지의 사진을 모아 GIF 형식의 이미지 파일로 만들어 줍니다. 이를 통해 사용자는 자신의 화훼 성장 과정을 한눈에 볼 수 있습니다.
* 또한 선택한 화훼작물이 다 자라 재배하게 되면 드라이플라워, 꽃다발, 꽃바구니 등 서비스 이용자가 원하는 형태로 배송해 줍니다. 사용자가 본인이 받지 않고 가족, 연인, 친구에게 선물하고자 할 경우, 직접 쓴 편지 혹은 템플릿을 제공해 완성된 편지를 포함하여 배송해 줍니다.

## 프로젝트 기능(제품 및 서비스 개발 부문 작품 공모)
* 직접 재배하지 않아도 농가의 재배지 일부 구역을 이용자의 구역으로 형성하여 원하는 작물을 대리 재배 및 실시간 스트리밍 기능 제공
* 작물의 성장 과정을 png, gif 형식으로 앨범 기능 제공
* 특정 시기(개화, 수확 등)마다 사진을 포함한 알람 기능 제공
* 커뮤니티를 통한 작물의 성장 과정 공유 및 재배 후 작물을 교환하거나 공유할 수 있는 기능 제공
* 단순 시각적 서비스뿐만 아닌 농가를 방문하여 체험해 볼 수 있는 경험 제공
* 실시간 작물의 병충해 및 성장 상태분석(농가 한정 제공)

> 프로젝트의 자세한 기획은 [Docs](https://github.com/JinhyeokKo/Project_Farm/tree/master/docs)를 통해 확인하실 수 있습니다.  
> 프로젝트를 진행하며 작업한 내역은 [Releases](https://github.com/JinhyeokKo/Project_Farm/releases)를 통해 확인하실 수 있습니다.

### 디렉터리 구조
```
├── MFP # 웹 백엔드 서버
├── MFP2 # 사용자 안드로이드 어플리케이션
├── MLAPI # 플라스트 통신 테스트 및 모델 운용 서
├── android_connected # 농가 설치용 안드로이드 어플리케이션
└── docs # 문서 관리용 폴더
```

### 기능 별 리포지토리
* Front : [Front](https://github.com/kyung89/frontened_proto_kyung)
* Back : [Back](https://github.com/JinhyeokKo/Project_Farm/tree/master/MFP)
* Android App : [Android App](https://github.com/JinhyeokKo/Project_Farm/tree/master/MFP2)
* Releases Note : [Releases](https://github.com/JinhyeokKo/Project_Farm/releases)
* 기획안 : [Docs](https://github.com/JinhyeokKo/Project_Farm/tree/master/docs)

### 팀원

|                                             고진혁                                            |                                             이왕훈                                            |                                        옥경림                                              | 정주애 | 최인규 |
|:--------------------------------------------------------------------------------------------:|:--------------------------------------------------------------------------------------------:|:-------------------------------------------------------------------------------------------:|:--:|:--:|
| <img src="https://avatars.githubusercontent.com/u/160887371?v=4" width="100" height="100" /> | <img src="https://avatars.githubusercontent.com/u/160670466?v=4" width="100" height="100" /> | <img src="https://avatars.githubusercontent.com/u/37587498?v=4" width="100" height="100" /> | <img src="https://cdn.simpleicons.org/github/7d7d7d" width="100" height="100" /> | <img src="https://cdn.simpleicons.org/github/7d7d7d" width="100" height="100" /> |
|                         [@JinhyeokKo](https://github.com/JinhyeokKo)                         |                            [@52hater](https://github.com/52hater)                            |                           [@kyung89](https://github.com/kyung89)                           |||
|                                               Back                                            |                                              App                                              |                                           Front                                           | Design | ML |
