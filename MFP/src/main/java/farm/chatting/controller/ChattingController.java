package farm.chatting.controller;

import farm.chatting.domain.Chatting;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class ChattingController {

    @MessageMapping("/chatting")
    @SendTo("/topic/chatting")
    public Chatting chatting(Chatting chatting) throws Exception {
        // 내부적으로 메서드 구현은 스레드를 1초 동안 절전 모드로 전환하여 처리 지연을 시뮬레이션합니다.
        // 이는 클라이언트가 메시지를 보낸 후 서버가 메시지를 비동기적으로 처리하는 데 필요한 만큼의 시간이 걸릴 수 있음을 보여주기 위한 것입니다.
        // 클라이언트는 응답을 기다리지 않고 수행해야 하는 작업을 계속할 수 있습니다.
        Thread.sleep(1000);
        // 1초 지연 후 Greeting() 메서드는 Greeting 객체를 생성하고 이를 반환합니다.
        // 반환 값은 @SendTo 주석에 지정된 대로 /topic/chatting 의 모든 구독자에게 브로드캐스팅됩니다.
        // 입력 메시지의 이름은 삭제됩니다. 이 경우 클라이언트측 브라우저 DOM 에서 다시 에코되고 다시 렌더링되기 때문입니다.
        return new Chatting(HtmlUtils.htmlEscape(chatting.getMessage()));
    }
}