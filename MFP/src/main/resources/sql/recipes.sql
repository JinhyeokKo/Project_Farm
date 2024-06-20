-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: recipe
-- ------------------------------------------------------
-- Server version	8.0.36

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `recipes`
--

DROP TABLE IF EXISTS `recipes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recipes` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `ingredient` varchar(200) NOT NULL,
  `recipe` varchar(1200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recipes`
--

LOCK TABLES `recipes` WRITE;
/*!40000 ALTER TABLE `recipes` DISABLE KEYS */;
INSERT INTO `recipes` (`id`, `name`, `ingredient`, `recipe`) VALUES (1,'양상추 샐러드','양상추 ​80g\n어린잎채소30g\n당근30g\n양파30g\n방울토마토5개\n진간장2숟갈\n사과식초2숟갈\n설탕1/2숟갈\n레몬즙2숟갈\n다진 마늘1/3숟갈\n​다진 양파1숟갈\n꿀1숟갈\n올리브유2숟갈','양상추는 흐르는 물에 씻어 손으로 뜯어준다.   \n어린잎 채소는 흐르는 물에 씻어 준다.   \n양파와 당근은 가늘게 채 썬다.   \n방울토마토는 반으로 자른다.   \n준비한 채소는 얼음 물에 담가 둔다.   \n손질한 채소들은 얼음 물에 담가 두었다가 먹기 직전에 요리하면 더욱 아삭한 맛을 즐길 수 있어요.   \n진간장 2숟갈, 사과식초 2숟갈, 레몬즙 2숟갈, 다진 양파 1숟갈, 다진 마늘 1/3숟갈, 꿀 1숟갈, 올리브오일 2숟갈, 설탕 1/2숟갈을 을 넣어 고루 섞어 양상추 샐러드 소스를 만든다.   \n접시에 양상추 샐러드 채소를 넣고 방울토마토로 예쁘게 장식한 뒤 먹기 직전에 양상추 샐러드 소스를 뿌린다.'),(2,'고추 장아찌','고추\n간장\n설탕\n식초\n물','간장1:설탕1:식초1:물1\n여기서 고추는 청양고추나 일반 고추나 좋아하시는 취향으로 하시면 됩니다.\n여기서 기억해두어야하는건 간장1:설탕1:식초1:물1비율로 하시면 됩니다.   \n고추를 흐르는 물에 깨끗하게 씻어주세요.   \n씻어낸 고추는 체에 걸러 물기를 제거해주시고 남은 물기는 키친타올이나 깨끗한 천으로 물기를 모두 제거해주세요.   \n고추의 꼭지 부분을 1cm정도만 남겨두고 잘라주세요.   \n간장1:설탕1:식초1:물1 비율로 넣고 펄펄 끓여준뒤 한숨 식혀줍니다.\n뜨거운김으로 넣지말고 손을 담갔을때 뜨뜬할 정도가 되었을때 넣어주세요.   \n장아찌를 담글 그릇을 준비한뒤 고추를 담아주고 고추가 잠길정도로 끓인 간장물을 넣어줍니다.   \n밖에서 이틀 을 숙성 시켜준뒤 냉장고에 보관해주세요'),(3,'도라지 무침','도라지600g\n굵은소금1/2스푼\n쌀뜨물\n고추장3스푼\n고추가루5스푼\n다진마늘1스푼\n설탕3스푼\n올리고당3스푼\n식초10스푼\n통깨2스푼','우선 제일 먼저 해주어야 할일은 도라지 특유의 아린맛을 없애주는 과정이예요.\n쌀뜬물에 굵은소금1/2스푼을 넣고 도라지를 20분정도 담구어서 놔둡니다.\n요렇게 하면 도라지의 아린맛을 제거해준답니다.   \n20분정도 담구어 두었던 도라지는 찬물에서 벅버 빨래하듯이 헹구어 주고\n가위를 이용해서 너무 긴것은 잘라서 준비합니다.\n그리고 체에 걸러 물기를 제거해줍니다.   \n고추장3스푼,고추가루5스푼,다진마늘1스푼,설탕3스푼,올리고당3스푼,식초10스푼   \n양념들을 잘섞어줍니다.   \n큰볼에 도라지를 옮겨 담은후 미리 만들어 두었던 양념장을 넣어줍니다.   \n깨도 듬뿍 2스푼 정도 넣어줍니다.   \n양념과 도라지가 잘섞이도록 조물조물 무쳐내주세요.'),(4,'딸기 라떼','딸기청3큰술\n생딸기2개\n우유1컵\n물1L\n식초1큰술   ','딸기는 식초물에 1분 정도 담갔다가 흐르는 물에 살살 흔들어 씻어 물기를 제거해주세요.\n물기를 제거한 딸기는 꼭지를 떼고 작게 썰거나 포크로 으깨 주세요.\n볼에 딸기와 설탕을 켜켜이 담고 레몬즙을 올려 살살 버무려주세요.\n설탕이 녹으면 소독한 유리병에 담고 뚜껑을 닫아주세요.\n(tip. 반나절 실온에 두었다가 냉장 보관해 이틀 정도 숙성시켜 주세요)\n유리컵에 딸기청과 우유를 넣어 맛있게 즐겨주세요.'),(5,'마늘 장아찌','통마늘20개\n식초1/2컵\n간장1/2컵\n설탕1/2컵\n소주1/2컵\n소금1t\n물300ml','깐 마늘을 깨끗하게 상처가 나지 않게 살살 잘 세척해서 키친타올로 물기를 제거해서 용기에 담아 주세요.   \n마늘장아찌 황금레시피로 담그기는 1차로 마늘의 아린 맛을 제거하기 위해서 삭혀 주어야 해요.\n1차 마늘 삭힘물을 만들어 주셔야 해요. 물의 양은 마늘을 용기에 꽉차게 부어서 양을 체크하심 되세요.\n부었다가 다시 쏟아서 거기에 약간 물을 더 넣고요.\n물300ml.식초1/2컵 그리고 소금을 안넣으셔도 되시는데요 소금 약간을 넣으면 아린맛이 더 빨리 제거가 된답니다.   \n끓이는거 아니구요. 찬물에 식초.소금,물을 넣고 그대로 삭혀 주심 되세요.\n물:식초=2:1 정도라고 보심 되세요.\n그리고 일주일 정도 그늘진 곳에서 삭혀 주시는데요 마늘이 파랗게 변하는 것을 방지하기 위해서 검정비닐이나 빛을 차단 할 수 있는 비닐을 씌워서 1주일간 실온에 보관해 주세요.   \n주일 지나고 나니 요렇게 삭혀지면서 빛깔이 요렇게 누르스름 해졌네요. 그럼 일주일 지난 마늘 절임물을 따라 준비해 주세요.   \n그럼 일주일 지난 마늘 절임물을 따라 준비해 주세요. 1차 삭힘물은 버리지 마시구요. 다시 2차 절임물로 사용할 거랍니다.\n마늘의 좋은 성분이 들어 있어서 그대로 사용할거랍니다. 그냥 사용하기 싫으신 분들은 물에 식초를 삭힘물과 같은 비율로 잡아서 새로 물을 준비해 주세요.   \n요렇게 마늘 일주일 삭힌 물에 설탕1/2컵.소주1/2컵.간장1/2컵을 넣고 보글 보글 끓여 주세요.\n그 다음에 보글 보글 끓인 2차 마늘장아찌 만들기 절임물을 한소뜸 식힌 후에 마늘이 담긴 용기에 부어 주세요.'),(6,'메론 소다','메론1개\n빙수용 팥 적당량\n연유\n우유 얼린것\n얼음\n아이스크림\n아몬드','메론은 1/3 지점에서 잘라 주세요. 너무 위쪽에서 자르면 얼음을 많이 넣어야 하므로 1/3 지점에서 잘라 주세요.\n균형이 잘 맞지 않는 메론은 아랫부분을 살짝 잘라 주세요.   \n수박화채숟가락이 있으면 예쁘게 동그랗게 파 주세요.\n메론 속 안을 깔끔하게 파 주세요.   \n팥빙수에 들어가는 재료(팥빙수 팥, 슬라이스 아몬드 등)를 준비해 주세요. 떡이 있으면 떡도 넣어 주세요. 팥빙수에는 연유를 넣어야 맛있습니다. 팥빙수용 팥만 넣으면 고소한 맛이 떨어집니다.   \n빙수 기계를 이용해서 얼음과 얼린 우유를 갈아 주세요.   \n동그랗게 판 메론을 가장자리에 둘러 주세요.   \n팥빙수용 팥과 연유를 올린 후 아이스크림을 올려 주세요. 꼭 견과류도 챙겨 넣어주세요.'),(7,'소고기 뭇국','무1/3개\n소고기 국거리용\n대파 1개\n참기름 2T\n간마늘 1T\n국간장 4T\n멸치육수 적당량','국거리용 소고기와 얇게 나박나박 썬 무를 준비해주세요. 무는 얇게 썰수록 조리시간이 줄어드니 조리시간 감안해서 썰어주세요.\n기호껏 고기와 무 양을 조절해주시면 된답니다.\n참기름 2T 넣고 중불에서 소고기를 먼저 볶아주세요.   \n참기름 넣고 볶다가 고기가 살짝 덜 익었을 때 국간장 4T 넣고 볶아주세요.\n국간장은 염도의 차이가 있어 1~2숟가락 넣어보시고 마지막 단계에서 추가해 주세요.\n소고기가 맛있게 달달 볶아지면, 썰어둔 무를 넣고 볶아주세요.   \n미리 끓여둔 멸치육수를 조금 붓고 뚜껑을 덮어 센불로 끓여주세요. 같은 방법으로 3번 반복해서 끓여주세요.\n여기서 포인트는 한번에 육수를 다 넣지 않고 육수를 3번 나눠서 조금씩 넣고 끓인다는 점 ! 무와 소고기의 맛이 국물에 진하게 우려나오도록 하기 위한 방법이에요.\n뚜껑 닫고 팔팔 끓이다보면 ! 고기에서 나오는 거무스름한 거품이 생기거든요, 거품을 제거해주세요.   \n간마늘 1T, 대파 1개를 송송 썰어 소고기무국에 투하! 간마늘 향 강한거 싫으시면 0.5T 줄여서 넣어주세요.   \n푹 끓여주면 소고기무국 완성이요 :)'),(8,'박나물 무침','채썬박 212g\n대파\n들기름 2큰술\n다진마늘 1/2큰술\n소금 1/2큰술\n깨소금','박은 껍질을 제거해주시고 박을 반으로 갈라 속에있는 씨를 제거해주세요.\n칼을 이용해 먼저 씨을 제거해주고 난뒤 숟가락을 이용해 박 씨를 제거해주면 조금 수월해요.\n박 종자로 박의 생김새가 달라요 박을 나물볶음 해놓았을때 쓴맛이 난다면 설 익은 박이라 하는데요 쓴맛이나는 박의 종자가 있다고는 하지만 쓴맛이 나는 박은 약성이 강하다고 하네요.\n박나물에 쓴맛을 제거하기위해 소금과 설탕에 절여 볶음은 해놓으면 쓴맛이 사라진다고합니다   \n박을 썰어 담아보니 212g이네요 박의 껍질부분에서 쓴맛난다해서 최대한 제거하고 썰어보니 생각보다 양이 적어요.\n대파는 송송 썰어준비해주세요. 팬에 대파와 채썬 박을 넣고 들기름 2큰술을 넣어 살짝 볶아주세요.\n볶아진 박나물에 다진마늘 반큰술정도와 소금 반큰술을 넣고 간이 베일수 있게 볶아줍니다.\n박나물은 보통 기본 레시피가 비슷비슷한거같아요.\n무나물 볶음과 비슷한 레시피라 박나물볶음을 처음 요리하신다면 무나물볶음을 생각하시면될거 같아요.   \n간이 잘베이면 종이컵 한컵 물을 넣고 약불에서 졸여주시면됩니다.\n박나물이 투명해질때까지 뒤적거리면서 졸여주시면 완성인데요, 중간에 간을 보시고 모자란 간은 소금으로 대신해주시고 깨소금을 넣어주면 박나물 볶음 완성입니다.'),(9,'방울토마토 마리네이드','방울 토마토 25개\n양파 1/2개\n올리브유 2+1/2큰술\n발사믹 식초 1큰술\n후추 약간\n설탕 1/3작은술\n소금 1/3작은술\n생바질 4잎','먼저 토마토 껍질을 벗겨주려고 하는데, 가운데에 열십자 칼집을 내줍니다.   \n이렇게 칼집을 낸 후 토마토 꼭지도 제거하는 것이 좋습니다. 전 데치고 꼭지를 제거해주었는데, 불편하더라구요.   \n전기 포트를 이용하여 물을 끓여준 뒤에 냄비에 끓는 물을 부어주면 시간을 단축할 수 있어서 좋습니다. 1리터의 물을 넣어주었구요.   \n끓는 물에 토마토를 넣어줍니다.   \n이 때 토마토를 꺼내는 시간은 토마토 껍질이 일어나기 시작하면 되는 것입니다.   \n자세히 보면 토마토 껍질이 일어나면서 살짝 껍질이 벗겨져 있는 것을 알 수 있지요? 이 때 꺼내시면 됩니다.   \n찬물에서 열기를 식힌 뒤에 껍질을 벗겨줍니다. 힘들이지 않고 잘 벗겨진답니다.   \n껍질을 벗긴 방울 토마토입니다.   \n좀더 크게 보시면 확연히 다르죠?   \n양파는 반 개를 곱게 다져줍니다. 양파를 쉽게 다지려면 가로, 세로 촘촘히 칼집을 낸 후 ( 양파 끝에는 칼집이 나지 않아야 하고요.) 썰어주면 다지기가 훨씬 쉽구요.   \n집에서 화분에 키우는 바질입니다.   \n굵게 가로 세로로 썰어주면 됩니다. 이 생바질이 없을 땐 병에 든 마른 바질을 사용하세요. 양은 좀 줄여서 넣어시고요. 왜냐하면 바질이 마르면 양이 훨씬 적어지기 때문이지요.   \n볼에 다진 양파, 바질을 넣어줍니다.   \n올리브유 2큰술 반 정도를 넣어주고   \n발사믹 식초를 1큰술 넣어줍니다. 이 발사믹 식초는 요즘 대형 마트에서 쉽게 구입할 수가 있답니다. 발사믹 식초는 이탈리아의 전통 식초로, 샐러드의 드레싱 등에 쓰이는데요, 청포도 즙을 졸인 다음 나무로 된 통 속에서 발효시켜서 만든답니다.   \n통후추도 약간 갈아서 넣어주고~ ( 전 통후추가 향이 좋아서 이것만 사용하게 되더라구요.)   \n설탕도 3분의 1작은술을 넣어줍니다. 그런 다음 잘 섞어줍니다.   \n데친 방울 토마토를 넣어서 다시 한번 잘 섞어줍니다.   \n마지막으로 소금간을 약간 해줍니다. 3분의 1작은술을 넣어주었구요.'),(10,'배추 겉절이','알배추 1통\n쪽파 10개\n굵은소금 1/2컵\n참기름 1스푼\n새우젓 1스푼\n액젓 3스푼\n고추가루 6스푼\n설탕 1스푼\n다진마늘 1스푼\n매실청 2스푼\n소금 약간','배추를 깨끗하게 씻고, 배추한장을 반으로 자른후 어슷하게 사진처럼 잘라줍니다.   \n굵은소금1/2컵을 준비한후 물을 1컵을 준비해서 배추 사이사이에 넣어서 30분에서 1시간정도 절여줍니다.   \n배추는 중간중간 한번씩 섞어서 골고루 절여지도록 해줍니다.   \n쪽파를 10줄을 준비한뒤 3cm~5cm크기로 잘라서 준비합니다.   \n새우젓1스푼, 액젓3스푼, 고추가루6스푼, 설탕1스푼, 마늘1스푼, 매실청2스푼으로 양념장을 만들어줍니다.\n양념장이 골고루 섞이도록 해주고 만약에 너무 퍽퍽하다면 물을 2스푼정도 넣어줍니다.   \n배추가 잘절여졌는지 아는 방법은 배추 줄기부분을 구부려봤을때 잘휘어지면 잘 절여진거랍니다. 절여진 배추는 찬물에 2-3번정도 헹구어 체에 걸러 물기를 빼줍니다.   \n이제 큰볼에 절인배추와 쪽파를 넣고 만들어둔 양념장을 넣어줍니다.\n양념장이 잘섞이도록 살살 버무려준다음   참기름을1스푼을 넣고 다시한번 버무려 주세요.\n그리고 모자란 간은 소금으로 맞추어주시면 됩니다.'),(11,'브로콜리 야채볶음','브로콜리\n양파\n당근\n파프리카\n다진마늘\n간장\n올리고당\n굴소스\n후추','당근, 양파, 파프리카등 채소를 사각사각 썰어주세요. 취향에 맞춰 채썰어 사용하셔도 상관없으세요.\n브로콜리를 깨끗히 씻어 먹기 좋은 크기로 썰어주세요. 송이부분위주로 사용해주시면 좋으세요.   \n브로콜리는 끓는 소금물에 살짝 데쳐 건져낸다음 찬물에 헹궈 물기를 쫘악 빼주세요. 오래 삶으시면 식감도 죽고 맛이 없어요.   \n다진마늘, 간장, 올리고당, 후추, 굴소스를 넣어 양념장을 만들어주세요.\n다진마늘 1스푼, 간장 3스푼, 올리고당 1스푼, 후추살짝, 굴소스 1스푼 사용해주었답니다.   \n달구어진 팬에 기름을 두르고 양파부터 당근까지 볶아주세요. 데친 브로콜리와 파프리카를 함께 볶아주세요.\n수분이 많은 채소들은 젤 마지막에 넣어 재빨리 볶아주셔야 물이 나오지 않아요.   \n양념장을 넣어 골고루 재빨리 볶아주시면 완성이에요.'),(12,'상추 겉절이','상추 12장\n양파 1/2개\n간장 3스푼\n고추가루 1.5스푼\n매실액 2스푼\n참기름 1스푼\n깨소금 1스푼\n다진마늘 1/2티스푼\n식초 1/2스푼\n깨 넉넉히','상추를 흐르는 물에 3~4번 씻어주세요.   \n깨끗하게 헹궈준 상추는 꼭 물기를 제거해주세요~! 물기 제거해주신 다음 먹기 좋은 크기로 4등분 정도 해주세요.\n물기 제거에 따라서 맛이 달라질 수 있다는 거 주의해주세요.\n볼에 상추를 담고 그 위에 양파 반개 썰어준 걸 담아주었는데요 이렇게 상추위에 양파 담으면 일단 기본 재료는 끝!\n양념장을 만들어줄건데요! 간장 3스푼, 고추가루 1스푼 반, 매실액 2스푼, 참기름 1스푼, 깨소금 1스푼 다진마늘 T스푼 반, 식초 1/2 스푼을 넣고 잘 섞어주시면 된답니다.\n넣어주시는 양은 본인 입맛에 맞게 가감해주시면 되세요.\n새콤하게 드시고 싶으시면 식초를 더 넣어주셔도 좋구요.\n단 맛을 원하시는 분은 매실액 or 설탕을 추가해주세요. 이제 상추위에 양념장을 올려주시구요. 조물조물 버무려주세요.   \n양념장이 잘 버무려진 상추와 아삭아삭해보이는 양파까지 이제 완성이에요.'),(13,'수박 화채','수박 1/2통\n사이다 250ml\n복숭아 1개\n사과 1/2개\n얼음 5개','수박은 1cm 두께로 썰어 모양틀로 찍어주세요.\n스쿱이 있으면 동그랗게 파주어도 좋아요.\n복숭아는 한입크기로 잘게 썰어주세요.   \n사과도 한입크기로 먹기좋게 썰어주세요.   \n사이다는 탄산을 빼주면 좀 더 부드러운 화채를 만들 수 있어요.\n탄산은 수저로 윗부분을 톡톡 쳐준 후 개봉하면 탄산이 빨리 빠진답니다,   \n넓은 볼에 준비한 과일을 넣고 사이다를 넣어주세요. 과일이 잠길만큼 넣고 여기에 우유를 추가해주면 훨씬 부드럽답니다.\n깔끔한 맛을 좋아하면 사이다만 넣어주세요.\n사이다를 넣은 화채에 얼음을 동동 넣어주세요. 얼음의 단점은 나중에 싱거워질 수 있으니 조금만 넣어주세요.\n얼린 사이다가 있으면 좋아요.\n완성된 시원한 과일화채,수박화채\n만드는법이 어렵지 않아 누구나 쉽게 만들 수 있어요.'),(14,'씀바귀 무침','씀바귀\n데침용 소금 1작은술\n식초 2큰술\n참기름 1.5큰술\n고추장 1.5큰술\n액젓 1큰술\n설탕 1큰술\n올리고당 1큰술\n다진마늘 0.5큰술\n다진파 2큰술\n깨 1큰술','먼저 겉의 흙등은 깨끗이 털고 많이 묻은 부분은 칼로 긁어 내고 물에 여러번 씻어 주세요.   \n소금 1작은술 넣고 끓는 물에 살짝 1분내로 데쳐낸 후, 다시 흐르는 찬물에 여러차례 헹군다음 꼬옥 짜서 물기를 빼 놓으세요.   \n양념장을 만들어 놓습니다.\n고추장 1.5, 액젓 1, 식초 2, 설탕 1,올리고당 1, 참기름 1.5, 다진마늘 0.5, 다진파 2, 통깨 +깨소금 1큰술   \n데쳐서 물기를 뺀 씀바귀를 양념장에 넣고 잘 버무려주면 맛있는 씀바귀 무침!! 완성입니다.\n쓴맛은 빠지고 맛있는 쌉싸름함이 있으면서 새콤~하고 달콤~하니 입맛을 제대로 돋구어 주는 맛있는 밑반찬입니다!'),(15,'양배추 겉절이','양배추 1/4개\n오이 1/2개\n다진마늘 1스푼\n썰은 파 2스푼\n소금 1/2스푼\n고춧가루 2+1/2스푼\n설탕 1스푼\n통깨 1/2스푼\n참기름 1스푼','양배추와 오이를 한입크기로 먹기좋게 썰어주세요.   \n믹싱볼에 함께 담아줍니다.   \n분량의 다진마늘, 파, 소금, 고춧가루, 설탕, 통깨, 참기름를 넣고 버무려줍니다.'),(16,'간장 양파 볶음','양파 4개\n올리브유 1T\n간장 2T\n설탕 1T','양파는 껍질을 벗겨주시고 깨끗이 씻어 주세요.   \n씻은 양파는 채썰어주세요.   \n후라이팬에 올리브유 1T를 넣고 채썬 양파를 볶아주세요.   \n양파 향이 솔솔 올라오면 간장 2T와 설탕 1T를 넣고 1분정도 더 볶아주시면 됩니다.\n맛을 보시고 취향에 따라 간장과 설탕을 더 추가해주세요. 모자란 간은 간장대신 소금으로 하셔도 되구요.'),(17,'여주 볶음','여주 150g\n양파 30g\n게맛살 2개\n계란 2개\n마늘 3쪽\n카놀라유 약간\n참기름 약간\n소금 약간\n깨','여주는 반으로 자르고 수저로 속을 긁어 낸다.   \n채 썬 다음 간간한 소금물에 담가 냉장고에 1시간 정도 두어 쓴맛을 뺀다.   \n생여주 쓴맛 빼주는 방법은 살짝 데친다. 찬물에 담근다.\n마늘은 편 썬다. 양파는 채 썬다.   \n계란은 소금 한 꼬집을 넣고 풀어 놓는다.   \n게맛살은 4㎝ 길이로 먹기 좋게 등분하여 자른다.   \n팬에 기름을 두르고 슬라이스 한 마늘을 넣어 살짝 볶아 준다.   \n마늘향을 낸 후 여주와 양파를 넣고 볶아 준다. 이때 간을 보아 소금으로 간을 맞춘다.   \n양파가 맑갛게 익어갈 때 게맛살을 넣고 살짝 볶아 준다.   \n재료를 한쪽으로 밀어 놓고 풀어 놓은 계란을 부어 스크램블을 만든다.   \n밀어 놓은 재료와 계란 스크램블이 골고루 섞어 지도록 살짝 볶는다.   \n마지막에 참기름과 깨 송송 뿌려 주면 여주볶음 만드는법 완성.'),(18,'참외 껍질 무침','참외껍질 참외 3개에서 나온 껍질 3개분\n굵은 고추가루 1큰술\n고운 고추가루 1큰술\n쪽파 1줄기\n황설탕 1/2큰술\n생강술 1/2큰술\n까나리액젓 1큰술\n매실청 1큰술\n다진 마늘 1/2큰술\n통깨 약간\n소금 약간\n식초 취향껏','베이킹소다를 1큰술을 참외에 뿌려 양손으로 비벼주고 3분 정도 담갔다가 수도꼭지를 틀어놓고 헹궈줍니다.   \n참외 양끝을 제거하고 가운데를 반을 자른 뒤에 껍질을 벗겨줍니다. 반을 자르는 이유는 채를 일정한 길이로 썰기 위해서입니다.\n채는 과육쪽으로 썰어주어야 칼이 미끄러지지 않아요.   \n분량의 재료를 넣고 양념장을 만듭니다. 새콤한 맛을 원하면 식초를 넣어주어도 좋아요.   \n볼에 채썬 참외를 넣어줍니다.   \n잘 버무려줍니다.   \n쪽파를 넣어 완성합니다. 없으면 대파를 잘게 썰어 넣어주세요.   \n통깨로 마무리합니다. 이 때 식초를 마지막에 추가하셔도 되구요.'),(19,'취나물 무침','취나물 300g\n깨소금 1큰술\n참기름 1큰술\n통깨 약간\n소금 약간','취나물은 다듬어서 끓는 물에 소금을 조금 넣고 데쳐줍니다. \n취나물을 데칠 때에는 줄기부분부터 넣고 데쳐주세요.   \n삶은 취나물은 흐르는 물에 헹구어 물기를 꼭 짜줍니다.   \n취나물은 먹기좋은 크기로 썰어줍니다.\n줄기의 억센 부분은 제거합니다.\n취나물을 볼에 담고 소금, 깨소금, 참기름을 넣고 고루 무쳐줍니다.'),(20,'토마토 달걀 볶음','토마토 중 3개\n계란 4개\n대파12cm크기 1개\n식용유\n진간장 1큰술\n굴소스 1큰술\n참기름 1/2큰술','달걀은 소금 한꼬집을 넣고 잘풀어주세요\n팬에 식용유를 넉넉히 넣고 센불에 달구어 계란을 넣고 스크램블 만들어줍니다.\n스크램블한 계란은 따로 접시에 담아 줍니다.\n스크램블 만들때 식용유를 넉넉히 넣어줘야 눌러 붙지 않고 잘 만들어집니다.\n팬을 달구어 스크램블을 만들어주는게 맛이 조금더 풍미가 있어요.\n스크램블을 더욱 부드럽게 만들고 싶다면 달걀에 있는 알끈을 제거해주고 거품기로 흰자와 노른자가 잘 섞이게 저어준다음 채반에 한번 걸러주고 스크램블을 만들어주면 더 부드러운 달걀을 맛볼 수 있어요.   \n대파는 송송 썰어 준비해주시고 토마토는 밑둥을 잘라 송송 썰어주세요.\n취향에 따라 다져주셔도 되고 반으로 잘라 썰어주셔도 될거 같아요.\n토마토가 사진처럼 조금 크다면 토마토를 칼집을 내어 살짝 데쳐 껍질을 제거하주고 토마토 달걀 볶음을 만들어 드시는게 더 좋아요.\n이렇게 큰사이즈이 토마토는 껍질이 질겨 씹히는 식감이 별로입니다.\n방울토마토나 사이즈가 작은 토마토는 그대로 썰어 사용해도 좋을거 같지만 흙토마토와 같이 사이즈가 큰 토마토는 데쳐주시는게 식감이 더 좋아요.\n토마토는 붉은색이 특징이라 강력한 항산화 작용을 하는 리코펜이 풍부해서 노화 예방이나 암예방으로 효능이 있다고 하니 챙겨드시는게 좋을거 같아요.\n팬에 식용유를 넣고 대파를 넣어 파기름을 내어 주세요 대파가 살짝 탈 때까지 볶아줘도 괜찮다고 하네요.\n파향이 올라오면 썰어둔 토마토를 넣어 볶아주세요 진간장 1큰술과 굴소스1큰술을 넣고 눌러붙지 않을 정도로 볶아주시면 됩니다.\n살짝 눌러 붙을 정도로 볶아 줘도 좋지만 어느정도 토마토 모양이 있어야 될거 같아 중불에서 볶아줬어요. 토마토가 어느정도 볶아지면 불을 잠시 끄고 모자란 간을 채워주시면 됩니다.\n스크램블 만들어 놓은 달걀을 넣고 다시 불을 켜서 토마토와 계란이 잘 어울리게 볶아주세요.\n마지막으로 참기름 1/2큰술을 넣어주면 토마토 달걀 볶음 완성입니다.\n토마토의 비타민이 흡수율을 높여주는 견과류와 오일이 가장 잘 어울리는 음식이라고 합니다.'),(21,'대파 볶음','대파 200g\n파프리카 1/4개\n양파 1/4개\n식용유 3Ts\n소금 1꼬집\n후춧가루 1꼬집\n물 20ml\n간장 1Ts\n올리고당 1/2Ts\n참기름 1Ts','대파는 먹기 좋게 자른다.   \n자른 대파는 열십자로 모양으로 한 번 더 자른다.   \n파프리카는 채 썰어 준다.   \n양파는 채 썰어 준다.   \n프라이팬에 식용유, 파프리카, 양파를 넣고 볶는다.   \n야채가 익으면 대파를 넣고 소금, 후춧가루를 넣고 볶는다.   \n물, 간장, 올리고당을 넣고 볶는다.   \n마지막으로 참기름을 넣어준다.'),(22,'애호박 볶음','호박 1개\n양파 1/2개\n당근 1/3개\n대파 2큰술\n들기름 2큰술\n다진마늘 1큰술\n새우젓 1큰술\n소금 적당량\n깨소금 적당량\n통깨','볶음'),(23,'귤 잼','손질한 귤 1340g\n설탕 1+1/2C\n소주 1/2C','귤을 껍질을 벗겨 손질한다. 귤 껍질은 말려서 겨울에 차를 끓여 먹어도 좋고, 껍질과 과육 사이의 흰 심지도 버리지 말고 먹어야 영양분을 모두 섭취할 수있는 과일이다.\n20개 분량을 손질하니 1,340g 정도 된다.   \n손질한 귤은 믹서나 핸드블랜더를 이용하여 갈아준다. 이 상태로 마시면 귤 주스가 된다.\n그냥 먹어도 새콤함 보다는 달콤함이 강한 맛있는 귤 주스가 되었다.   \n잘 갈아진 귤은 잼 만들 냄비에 넣고, 설탕 1 + 1/2C을 부어 잘 섞어준다.   \n방부제 역할을 해 줄 소주 1/2C도 같이 넣고, 강한 불을 이용하여 끓이기 시작한다.   \n계속 저으면서 끓인다. 끓기 시작하면 중간불로 옮긴다.   \n저으면서 생가는 거품은 걷어낸다. 깔끔한 잼을 만들기 위해서이다.   \n중간불로 계속 저으면서 귤잼을 만드는 동안 한 쪽에서는 끓는 물에 유리병을 열탕하여 소독한 뒤 물기를 완전히 말린다.   \n20분 가량 졸여 완성한 귤잼은 식혀서 물기 없는 유리병에 보관한다.\n냉장고에 넣고 보관 하였다가 식빵에 발라 먹으면 맛이 좋다.'),(24,'단감 깍두기','단감 2개\n고춧가루 1T\n액젓 1/2T\n다진 마늘 1t\n부순깨 1/2T\n대파 약간','먼저 단감의 껍질을 벗겨 먹기 좋은 크기로 적당히 썰어주세요.\n이때 씨가 있으면 제거해주시고, 가운데 심지는 떨떠름한 맛이 나니 살짝 잘라내주는 게 좋겠죠!\n썰어놓은 단감에 고춧가루를 넣고 조물조물 섞어 밑색을 입혀주세요.   \n여기에 액젓, 다진 마늘, 부순깨, 대파를 넣고 한 번만 더 섞어주면 오늘의 요리 끝!\n제 단감은 굉장히 달아서~ 따로 단맛을 추가하지 않았는데. 덜 달다 싶으면 올리고당 or 매실청을 추가로 넣어주셔도 OK.\n완성된 무침은 맛을 보시고 싱겁다 싶으면 액젓, 고춧가루, 매실청으로 간 조절을 해주는 게 좋겠죠!!'),(25,'매실 장아찌','손질 후 매실 3.5kg\n설탕 3kg\n천일염 2T\n설탕 500g','상처난 매실은 골라내고 물에 씻어요~ 물기를 빼줍니다.   \n꼭지는 이쑤시개나 손톱으로 띠어내요~ 알이 커서인지 잘익어서인지 꼭지가 아주 쉽게 제거되네요~   \n행주 3장정도 깔고 도마올리고 방망이를 준비합니다. 매실을 도마에 올리고 방망이로 세게 내려칩니다.   \n방망이로 쳐서 담아놓고 손으로 씨를 발라냅니다.      \n천일염 2T 정도로 살짝 밑간합니다. 까불러서 잠시 놔둬요~   \n소금에 절인 매실에 설탕 3Kg를 넣고 버무려요~ 잠시 놔두었다가 통에 담아요~   \n매실육즙에 설탕이 금방 녹아요~ 위에 설탕 500g 을 덮어서 베란다에 두었어요~   \n거품이 많이 생기면 주걱으로 아직 덜 녹은 설탕을 저어줍니다.   \n거품도 많이 줄고 설탕도 다 녹았고 매실 수분은 더 빠지고 또 먹어봅니다. 새콤, 달콤해지고 익으면 건져서 냉장보관합니다.\n매실이 잠길정도 청만 남기고 저장하면 아주 아삭한 매실을 드실 수 있어요~'),(26,'배 샤베트','배 1.5개\n라임 1개\n설탕 또는 꿀 3숟가락\n탄산수 약간','라임은 반으로 잘라 즙을 내서 준비해요.   \n배는 껍질을 벗겨 믹서기에 넣어 갈아요.\n설탕을 넣어 함께 갈아요.   \n갈아놓은 배에 라임즙을 넣어요.   \n잘 섞어 냉동 보관해요.\n중간 중간 한번씩 포크로 긁어주세요.\n냉동에 약 6시간 이상 얼려 꺼내 완성해요.'),(27,'복숭아 통조림\n','복숭아 6개\n설탕 200ml\n물 2컵\n소금 0.5T','복숭아는 먼저 깨끗하게 세척해주세요.   \n세척한 복숭아는 이정도 크기로 등분하여 잘라내고 껍질을 벗겨줍니다   .\n껍질 벗겨서 자른 복숭아는 이렇게 한데 모아줍니다. 설탕반컵, 물한컵을 넣고 섞어줍니다.\n저는 단걸 많이 좋아하지않아서 설탕은 반컵만 넣었지만, 단걸 좋아하시는 분들은 1:1비율로 만드시면 됩니다.   \n가스불을 키고 설탕을 녺여주세요.   \n설탕이 어느정도 녹았다면 미리 잘라논 복숭아를 몽땅 넣습니다.\n10분정도 끓이면 이렇게 보글보글 끓으면서 색이 더 선명해져요.   \n단맛을 극대화하기위해 0.5T 소량의 소금을 넣습니다.   \n20분쯤 끓이면 이렇게 복숭아는 투명한 빛을 내요 이때 가스불을 꺼주시고 식혀주세요.   \n다 식힌 복숭아조림은 용기에 담아서 냉장보관해두시고 시원하게 디저트로 드시면 됩니다.'),(28,'사과 파이','박력분 230g\n차가운 버터 120g\n차가운 물 50g\n소금 2g\n사과 2~3개\n설탕 70g\n레몬즙 1큰술\n계피가루 1티스푼\n계란 1개','박력분과 소금은 체로 쳐주세요. 차가운 버터를 넣어주세요.   \n주걱으로 # 모양으로 가르듯이 섞어 보슬보슬하게 만들어주세요.   \n차가운 물을 넣고 가르듯이 섞어 반죽을 한덩어리로 뭉쳐주세요.   \n비닐팩에 반죽을 넣고 냉장고에 30분정도 휴지시켜주세요.   \n파이지를 휴지시키는 동안 사과필링을 만들어볼게요.   \n사과는 씨부분을 제거해준뒤 0.5cm 두께로 슬라이스 해주세요.\n냄비에 잘라놓은 사과와 설탕 레몬즙을 넣어주세요.   \n중불로 사과의 색이 갈색빛이 날때까지 졸여주세요.   \n계핏가루를 넣어주세요.   \n냄비 밑부분에 수분이 하나도 없을때까지 중불에서 계속 끓여준뒤 식혀주세요.   \n휴지된 반죽을 0.3cm 정도 두께로 밀어펴주세요.   \n타르트 틀에 밀어편 반죽을 붙여준뒤 바닥부분을 포크로 찍어주세요.\n(바닥부분을 포크로 찍어야 고르게 부풀어 오른답니다)   \n만들어둔 사과필링을 넣어주세요.   \n남은 반죽을 길게 밀어펴 1cm 두께로 잘라주세요.   \n지그재그로 교차시켜 위에 올려주세요.   \n계란 하나를 풀어 윗면에 발라주세요.\n(계란물을 발라주면 파이의 색이 노릇노릇 맛있게 된답니다)   \n190도의 오븐에서 30분정도 구워주면 맛있는 애플파이 완성입니다.'),(29,'살구 잼','살구 1kg\n식초\n설탕 500~700g','살구를 식초물에 살짝 씻어요.\n살구를 반으로 쪼개서 씨와 분리해요.   \n살구와설탕을 골고루 잘 버무려요.\n살구 1Kg : 설탕600g.\n살구 : 설탕 =1:0.5~0.7.\n설탕과 잘 버무려서 살구를 30분정도 숙성시켜요.   \n살구에서 맛있는 즙이 나온답니다. 이때 도깨비방망이로 곱게 갈아주세요.   \n곱게 간 살구를 중불에서 잘저어주며 끓여요. 부글부글 끓으면 약불에서 30분정도 타지않게 잘저어주어요.   \n찬물에 떨어뜨려보아서 풀어지지 않으면 살구잼완성이랍니다.'),(30,'자두청','자두15개\n설탕2컵','자두청 재료로 자두 15개 정도 설탕을 준비했어요.\n자두는 깨끗하게 씻어 작게 잘라 주어요.   \n자른 자두를 볼에 넣고 설탕을 부어 줍니다.\n자두 수분이 많아서 바로 국물이 생깁니다.   \n30분도 지나지 않아서 설탕이 많이 녹았어요.   \n자두청 담을 유리병은 냄비에 중탕소독후 물기를 제거 합니다.\n* 유리병이라 깨질수 있으므로 조심 하세요.   \n소독된 유리병에 자두청 만들어진것을 담아요.      \n2일 냉장보관 합니다.\n* 약처럼 효소로 먹을것이 아니라 냉장보관후 3일부터 자두음료와 에이드 만들어 먹기 시작했어요'),(31,'자두청 에이드','자두 청 4~5숟가락\n사이다(탄산수) 1캔','자두 4~5숟가락에 시원한 사이다1캔(탄산수)를 넣어 줍니다.\n* 더 시원함을 원한다면 얼음 몇개 톡톡   \n더운날 자두에이드나 샐러드에 아니면 간단한 브런치에도 잘 어울리는 자두청입니다.'),(32,'키위 카나페','크래커 4개\n키위 1개\n바나나 1/3개\n블루베리 4개\n래핑카우 포션 치즈 2개\n다진 수박 2T','비스켓위에 슬라이스한 키위를 올립니다.   \n키위 위에 래핑카우 포션치즈를 올립니다. 다른치즈도 괜찮지만, 이 치즈가 엄청 진하고 맛이 풍부하네요.   \n오늘의 주인공은 키위라서 키위를 다져서 또 올립니다.   \n색이 골고루 들어가야 이뻐서 빨간색은 딸기나수박, 블루베리, 바나나를 사용합니다. 색별로 사용하면 됩니다.'),(33,'다래 달고맛나지','다래 15개\n바게트 4~5조각\n크림치즈 1T','숙성되어 잘 익은 토종 다래 잘 씻은 후 겁질째 쭉~ 눌러주니 과육만 쑥 나옵니다.\n그릇에 담아요.\n빵에 바로 올려서 먹으니 쨈 만들필요없어도 되네요.   \n진심 달고 맛이 좋아요.   \n크림치즈와 섞어섞어~~.\n개인적으로는 넘 맘에 드는 디핑소스가 되어 주네요.\n크림치즈의 짭쪼롬함이 있어서 소금도 필요없어요.'),(34,'포도 주스','포도 3송이\n설탕 1/2종이컵','포도를 알알이 따주세요. 포도를 베이킹소다에 씻어줍니다. 베이킹소다만 믿고 그냥 살랑살랑 흔들어 씻어줍니다.   \n냄비에 깨끗히 씻은 포도알을 넣은 후 설탕을 뿌려 줍니다.   \n밑에 물을 살짝 깔아주고 불을 올려 끓여주세요.   \n즙을 내리기 위해 체반에 끓어 푹 물러진 포도를 받쳐 긁어주며 즙을 내려줍니다.   \n다 내려진 포도즙은 원하는 농도가 될 때 까지 바글바글 끓여주면 일명 포도엑기스 만들기 끝!'),(35,'감초주','감초 잘게 썬 것 150g\n소주 2ℓ','잘게 썬 감초와 소주를 밀폐 용기에 담고 뚜껑을 닫는다.\n서늘한 곳에서 3개월 정도 숙성시킨 후 거즈나 베 보자기에 건더기를 걸러 술만 받는다.'),(36,'느타리버섯 볶음','느타리버섯 2팩\n양파 1/2개\n청량초 1개\n당근 조금\n맛간장 1큰술\n굴소스 1/2큰술\n다진마늘 1큰술\n후추 톡톡\n올리고당 1티스푼\n올리브유 적당량','고추ᆞ당근ᆞ양파 썰어 준비합니다.\n느타리버섯은 밑동을 잘라 주고 굵은 버섯은 찢어주세요.\n끓는 물에 살짝 데쳐주시고 찬물에 헹궈 물기를 최대한 꾹~ 짜주세요.\n버섯 팬에 담고 준비한 야채 넣어주세요.\n위 양념 모두 넣어주세요.\n슥슥~ 볶아주면 끝입니다.'),(37,'당귀나물무침','당귀나물\n소금\n다진마늘 1ts\n다진파 1ts\n깨\n소금 1ts\n참기름 1ts','당귀나물을 다듬어주세요.\n다듬은 당귀를 깨끗이 씻어서 끓는물에 살짝 데쳐주세요.\n소금도 넣고요 3분~5분 너무 오래면 안돼요.\n데친 당귀를 찬물에 헹궈서 체에받쳐 물기를 빼주고 손으로 꼭 짜줍니다   .\n그리고 볼에 담아 양념을 넣고 조물 조물 버무리면 완성.'),(38,'들깨 미역국','미역 300g\n들깨가루 5~6T\n멸치다시육수\n들기름 2T\n국간장 2T\n소금 약간\n다진마늘 0.5T','미역을 물에 불려주시고 바락바락 문질러주세요.\n들기름 2번 두르고 다진 마늘 반 스푼 넣고 달달 볶아주세요.\n미역이 살짝 투명해지면 멸치다시육수를 붓고 끓여줍니다.   \n국간장 2스푼 넣고 들깨가루 5~6스푼 넣어줍니다.\n2~30분 정도 푹 끓여주세요.'),(39,'땅콩버터','볶은 땅콩 100g\n포도씨유 2작은술\n꿀 1~2큰술','볶은 땅콩은 껍질을 벗겨서 준비하고, 분량의 꿀과 포도씨유도 준비합니다.   \n분쇄기에 땅콩을 먼저 넣고 휘리릭 갈아주세요.\n그리고 꿀과 포도씨유를 넣고 돌리고 멈추고, 다시 돌리고 멈추고를 반복하며 갈아주세요.\n분쇄기 또는 믹서 중간중간 멈추고 입자를 확인해주세요.\n윤기가 돌며 손으로 만졌을 때 입자가 거의 느껴지지 않으면 완성입니다.'),(40,'상황버섯차','상황버섯','흐르는 물에 이물질을 제거한 후 깨끗이 씻어 물기를 없앤 후 이용합니다.\n한달분(100g)정도는 밀폐용기에 담아 건조하고 서늘한 곳으로 상온에 보관합니다.\n대용량은 알맞게 소분해서 냉장보관합니다. 상황버섯이 물에 닿지 않게 합니다.\n물에 젖은 버섯은 가능한 빨리 드시고 보관시는 냉동합니다.\n물에 젖은 상황버섯은 상할 수도 있답니다.\n\n상황버섯 30~50g과 생수 2L를 준비합니다. 수돗물보다는 생수를 이용합니다.\n버섯을 작게 자릅니다.\n유리, 사기, 약탕기,도자기류 그릇으로 달이는 것이 약성을 최대한 볼 수있는 최고의 방법이예요.\n금속류 그릇은 다당체 성분이 용기에 붙어 영양소가 손실 될 수 있습니다.\n상황버섯은 목질이 단단하여 베타글루칸이 한번에 용해 되지 않으므로 3~4회 재탕합니다.\n녹각영지버섯, 대추, 생강과 같이 끓여 드셔도 좋구요. 감초는 아주 조금만 넣으셔요.\n\n상황버섯차 드시는 방법\n1회 100cc 복용합니다. 같은 양의 물을 더해서 드셔도 좋아요.\n처음 일주일 동안은 하루에 1~2회 복용합니다.\n우리 몸에 적응 되었다 싶으시면 ( 기상전, 취침전, 식전) 하루 3~5회 복용합니다.\n따뜻하게 드시면 흡수가 더 잘 되구요. 차갑게 드실때는 단백다당류가 침전 될 수 있으니 흔들어서 드시면 되셔요.'),(41,'양송이버섯 스프','양송이 6개\n양파 0.5개\n마늘 1개\n버터나 올리브유 1스푼\n밀가루 2스푼\n버터 2스푼\n우유 500ml\n생크림 250ml\n소금 약간\n후추 약간','양송이와 양파, 깐마늘은 다져서 준비해 주시는데 저는 잘게 다졌지만 좀더 양송이의 씹는 식감을 느끼고 싶으신 분들은 취향껏 원하는 크기로 다져주시면 되어요.   \n팬에 올리브유나 버터1스푼을 두르고 다진 마늘을 넣고 볶다가 양송이와 양파도 넣고 볶아주세요.   \n볶은 양송이, 양파, 마늘은 따로 그릇에 빼놓고 팬을 정리하신후 루를 만들어 볼께요.   \n먼저 버터 2스푼을 팬에 녹여주시는데 센불에서 녹이면 금방 타버릴 수 있기 때문에 약한불에서 저처럼 팬을 살짝 기울려서 들고 녹이시면 버터가 타지 않고 잘 녹는답니다.   \n잘 녹인 버터에 밀가루 2스푼, 우유1스푼을 넣고 재빠르게 볶아주시면 루 완성!!!\n루에 그릇에 담아놓은 볶은 양송이, 양파, 마늘을 넣고 우유 500ml를 부어주세요.   \n생크림도 250ml 부어주면 이제 맛있게 보글보글 끓을 동안 농도를 확인하며 잘 저어 주셔야 한답니다.   \n어느정도 걸죽하게 스프의 농도가 맞춰진 후 마지막으로 소금, 후추로 취향에 맞게 간을 하면 완성!!!'),(42,'유채나물무침','유채나물 1봉지\n된장 1큰술\n다진파 1큰술\n다진마늘 1/2큰술\n참기름 1큰술\n깨소금 1/2큰술\n소금 1/2작은술','유채나물은 끓는물에 데쳐줍니다.\n줄기가 말랑하면 꺼내서 찬물에 헹궈주세요.   \n된장과 양념을 모두넣고 조물조물 무쳐주세요.\n된장과 소금은 집집마다 다르니 간을 봐가면서 해주세요.'),(43,'인삼꿀절임','인삼 150g\n꿀 넉넉히','우선 인삼을 씻어줍니다.   \n깨끗하게 씻은 인삼은 뇌두부분이라고 하죠. 젤 윗부분 잘라내주고요,\n뇌두부분은 독성이 있어 먹으면 안된대요.\n잔뿌리 부분도 잘라서 놔둡니다.\n이건 삼계탕이나 인삼 들어가는 음식에 사용하면 되니 냉동실에 얼려두면 됩니다.   \n이제 인삼 몸통부분은 동그랗게 썰어줍니다.\n동그랗게 싫으시면 어슷하게 썰어도 됩니다.\n소독한 유리병에 인삼 넣어주고요...   \n꿀은 아무거나 사용하시면 됩니다.   \n이제 인삼이 든 유리병에 꿀을 넣어줍니다.\n잠기게 넣어주면 됩니다.   \n이제 요대로 나무 수저로 골고루 저어주고 절여주면 됩니다.\n한나절 정도 실온에 뒀다가 냉장고에 넣어두고 다음날부터 먹으면 됩니다.'),(44,'참깨드레싱','참깨 6T\n검은깨 2T\n간장 2T\n발사믹식초 2T\n마요네즈 4T\n설탕 2T\n올리고당 4T\n물 2T','재료들을 분량대로 넣어주세요.\n검은깨가 없으시면 참깨로만 하셔도 되요!\n발사믹식초가 없으시면 간장:식초=1:1을 넣어서 만드시면 됩니다.\n만들어준 재료들을 믹서기에 넣고 잘 갈아주세요.\n잘 갈려진 참깨드레싱을 그릇에 담아서 냉장보관해두세요.'),(45,'팽이버섯구이','팽이버섯 1봉지\n버터 약간\n다진마늘 1스푼\n쪽파/대파 약간\n소금 조금','먼저 후라이팬에 버터를 취향만큼 올려 녹여주세요.\n버터를 녹이면서 다진마늘 1스푼도 넣어 볶아주었어요.\n소금 한꼬집정도 조금 넣어 같이 볶아주시면 돼요.\n이때 중요한것은 매운 마늘향이 아닌 마늘이 고소한 향이 날때까지 볶아주면 됩니다.\n그리고 그 위에 팽이버섯을 가지런히 올립니다.\n이 요리의 특징은 팽이버섯을 뒤적거리지않고 뒤집지도 않고!! 그냥 이상태로 요리하는거랍니다.\n서서히 물기가 나오기 때문에 물에 쪄지는 효과가 있어 뒤집을 필요가 없습니다.\n양념이 버섯에 잘 스며들고 노릇노릇해지면 불을 끄고 접시에 올려주시고 후라이팬에 남은 마늘들이 있을거에요~\n그건 그대로 그릇에 담지말고 쪽파나 대파 잘게 썰어 같이 살짝더 볶아주고 요로코롬 버섯위에 올려주면 고명으로 먹을수 있어요.');
/*!40000 ALTER TABLE `recipes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-12 12:02:59
