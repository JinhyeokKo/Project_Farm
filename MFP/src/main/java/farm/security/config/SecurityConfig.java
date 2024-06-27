package farm.security.config;

import farm.member.repository.MemberRepository;
//import farm.security.filter.CsrfCookieFilter;
import farm.security.filter.JWTAuthenticationFilter;
import farm.security.filter.JWTAuthorizationFilter;
//import farm.security.handler.SpaCsrfTokenRequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.AuthorizationFilter;
//import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
//import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final AuthenticationConfiguration authenticationConfiguration;
    private final MemberRepository memberRepository;

    @Autowired
    public SecurityConfig(AuthenticationConfiguration authenticationConfiguration, MemberRepository memberRepository) {
        this.authenticationConfiguration = authenticationConfiguration;
        this.memberRepository = memberRepository;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .sessionManagement((session) -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .authorizeHttpRequests((auth) -> auth
                        .requestMatchers(
                                new AntPathRequestMatcher("/login/**"),
                                new AntPathRequestMatcher("/likes/**"),
                                new AntPathRequestMatcher("/comments/**"),
                                new AntPathRequestMatcher("/report/**"),
                                new AntPathRequestMatcher("/posts/**"),
                                new AntPathRequestMatcher("/upload"),
                                new AntPathRequestMatcher("/program/**"),
                                new AntPathRequestMatcher(("/ws/**")),
                                new AntPathRequestMatcher("*")
                        ).permitAll()
                        .requestMatchers(
                                new AntPathRequestMatcher("/message/**"),
                                new AntPathRequestMatcher("/like/**"),
                                new AntPathRequestMatcher("/comment/**"),
                                new AntPathRequestMatcher("/post/**"),
                                new AntPathRequestMatcher("/user/**")
                        ).authenticated()
                )
                .csrf(AbstractHttpConfigurer::disable
//                        (csrf) -> csrf
//                        .ignoringRequestMatchers(
//                                new AntPathRequestMatcher("/login/**"),
//                                new AntPathRequestMatcher("/report/**")
//                        )
//                        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
//                        .csrfTokenRequestHandler(new SpaCsrfTokenRequestHandler())
                )
                .formLogin(AbstractHttpConfigurer::disable)
                .addFilterBefore(new JWTAuthorizationFilter(memberRepository), AuthorizationFilter.class)
                .addFilter(new JWTAuthenticationFilter(authenticationConfiguration.getAuthenticationManager()))
                //.addFilterAfter(new CsrfCookieFilter(), BasicAuthenticationFilter.class)
                .build();
    }

}
