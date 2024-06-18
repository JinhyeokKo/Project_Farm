package farm.chatting.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    // 메시지 브로커를 구성하기 위해 WebSocketMessageBrokerConfigurer의 기본 메서드를 구현합니다.
    // 간단한 메모리 기반 메시지 브로커가 접두사가 /topic인 대상의 클라이언트에 인사말 메시지를 다시 전달할 수 있도록 활성화하기 위해
    // 활성화SimpleBroker()를 호출하는 것으로 시작됩니다.
    // 또한 @MessageMapping으로 주석이 달린 메서드에 바인딩된 메시지에 대해 /app 접두사를 지정합니다.
    // 이 접두사는 모든 메시지 매핑을 정의하는 데 사용됩니다.
    // 예를 들어 /app/hello는 GreetingController.greeting() 메서드가 처리하도록 매핑된 엔드포인트입니다.
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic");
        config.setApplicationDestinationPrefixes("/app");
    }

    // 웹소켓 연결을 위해 /gs-guide-websocket 엔드포인트를 등록합니다.
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/gs-guide-websocket");
    }
}
