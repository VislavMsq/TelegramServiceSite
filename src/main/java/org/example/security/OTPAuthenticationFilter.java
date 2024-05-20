//package org.example.security;
//
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//import javax.servlet.FilterChain;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//public class OTPAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
//
//    public OTPAuthenticationFilter() {
//        super(new AntPathRequestMatcher("/login", "POST"));
//    }
//
//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
//            throws AuthenticationException, IOException {
//        String code = request.getParameter("username");
//
//        // Створюємо токен аутентифікації з кодом
//        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(code, null);
//
//        return this.getAuthenticationManager().authenticate(authRequest);
//    }
//
//    @Override
//    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
//                                            FilterChain chain, Authentication authResult) throws IOException {
//        SecurityContextHolder.getContext().setAuthentication(authResult);
//        response.sendRedirect("/home");
//    }
//
//    @Override
//    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
//                                              AuthenticationException failed) throws IOException {
//        response.sendRedirect("/login?error");
//    }
//}
//
