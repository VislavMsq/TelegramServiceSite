package org.example.security;

import lombok.RequiredArgsConstructor;
import org.example.service.WebUserService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;

@Controller
@RequiredArgsConstructor
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final WebUserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        boolean passwordIsValid = checker(username, password);

        if (passwordIsValid) {
            return new UsernamePasswordAuthenticationToken(username, password, new ArrayList<>());
        } else {
            throw new AuthenticationException("Invalid login or password") {
            };
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

    private boolean checker(String username, String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        try {
            if (userService.existByEmail(username)) {
                return passwordEncoder.matches(password, userService.findByEmail(username).getPassword());
            }
        } catch (Throwable ignore) {
        }
        return false;
    }
}
// $2a$10$IbiGuULi9ne7GNeAyCQym.k.ZmUEDHRmUg3Dq0CgztIHYVmWaMvk2