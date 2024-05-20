//package org.example.security;
//
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.stereotype.Component;
//
//@Component
//public class OTPAuthenticationProvider implements AuthenticationProvider {
//
//    private final UserDetailsService userDetailsService;
//
//    public OTPAuthenticationProvider(UserDetailsService userDetailsService) {
//        this.userDetailsService = userDetailsService;
//    }
//
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        String code = authentication.getName();
//
//        // Реалізуйте логіку перевірки одноразового коду
//        if (isValidOTP(code)) {
//            UserDetails userDetails = userDetailsService.loadUserByUsername("testuser");
//            return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//        } else {
//            throw new AuthenticationException("Invalid OTP") {};
//        }
//    }
//
//    private boolean isValidOTP(String code) {
//        // Реалізуйте свою логіку перевірки одноразового коду тут
//        return "123456".equals(code); // Замість цього використовуйте реальну логіку перевірки
//    }
//
//    @Override
//    public boolean supports(Class<?> authentication) {
//        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
//    }
//}
//
