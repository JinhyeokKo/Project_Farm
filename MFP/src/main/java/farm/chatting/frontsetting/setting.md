## 채팅 통신을 위한 프론트 설정 및 라이브러리
* [참고 문헌 바로가기](https://spring.io/guides/gs/messaging-stomp-websocket)
> websocket을 통한 STOMP를 통해 서버와 통신하는 데 사용되는 StompJS 자바스크립트 라이브러리를 가져옵니다.
>```html
><script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
><script src="https://cdn.jsdelivr.net/npm/@stomp/stompjs@7.0.0/bundles/stomp.umd.min.js"></script>
>```
```javascript
// app.js 구성
const stompClient = new StompJs.Client({
    brokerURL: 'ws://localhost:8080/gs-guide-websocket'
});
// StompClient는 웹소켓 서버가 연결을 기다리는 위치인 /gs-guide-websocket 경로를 참조하는 BrokerURL로 초기화됩니다.
// 성공적으로 연결되면 클라이언트는 서버가 인사말 메시지를 게시할 /topic/chatting 대상을 구독합니다.
// 해당 대상에서 인사말을 받으면 DOM에 단락 요소를 추가하여 인사말 메시지를 표시합니다.
stompClient.onConnect = (frame) => {
    setConnected(true);
    console.log('Connected: ' + frame);
    stompClient.subscribe('/topic/chatting', (greeting) => {
        showGreeting(JSON.parse(greeting.body).comment);
    });
};

stompClient.onWebSocketError = (error) => {
    console.error('Error with websocket', error);
};

stompClient.onStompError = (frame) => {
    console.error('Broker reported error: ' + frame.headers['message']);
    console.error('Additional details: ' + frame.body);
};

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#chatting").html("");
}

function connect() {
    stompClient.activate();
}

function disconnect() {
    stompClient.deactivate();
    setConnected(false);
    console.log("Disconnected");
}

function sendName() {
    stompClient.publish({
        destination: "/app/hello",
        body: JSON.stringify({'message': $("#message").val()})
    });
}

function showGreeting(message) {
    $("#greetings").append("<tr><td>" + message + "</td></tr>");
}

//sendName() 함수는 사용자가 입력한 이름을 검색하고 STOMP 클라이언트를 사용하여
// 이를 /app/hello 대상(GreetingController.greeting()이 수신하는 곳)으로 보냅니다.
// 원하는 경우 main.css를 생략하거나 <link>를 확인할 수 있도록 빈 것을 만들 수 있습니다.
$(function () {
    $("form").on('submit', (e) => e.preventDefault());
    $( "#connect" ).click(() => connect());
    $( "#disconnect" ).click(() => disconnect());
    $( "#send" ).click(() => sendName());
});
```