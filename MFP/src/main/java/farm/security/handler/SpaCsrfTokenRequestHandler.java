//package farm.security.handler;
//
//
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.security.web.csrf.CsrfToken;
//import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
//import org.springframework.security.web.csrf.CsrfTokenRequestHandler;
//import org.springframework.security.web.csrf.XorCsrfTokenRequestAttributeHandler;
//import org.springframework.stereotype.Component;
//import org.springframework.util.StringUtils;
//
//import java.util.function.Supplier;
//
//@Component
//public class SpaCsrfTokenRequestHandler extends CsrfTokenRequestAttributeHandler {
//    private final CsrfTokenRequestHandler delegate = new XorCsrfTokenRequestAttributeHandler();
//
//    @Override
//    public void handle(HttpServletRequest request, HttpServletResponse response, Supplier<CsrfToken> deferredCsrfToken) {
//        this.delegate.handle(request, response, deferredCsrfToken);
//    }
//
//    @Override
//    public String resolveCsrfTokenValue(HttpServletRequest request, CsrfToken csrfToken) {
//        if(StringUtils.hasText(request.getHeader(csrfToken.getHeaderName()))){
//            return super.resolveCsrfTokenValue(request, csrfToken);
//        }
//        return this.delegate.resolveCsrfTokenValue(request, csrfToken);
//    }
//}
