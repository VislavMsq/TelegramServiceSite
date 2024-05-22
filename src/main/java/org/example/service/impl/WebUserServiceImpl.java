package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.entity.enums.ErrorMessage;
import org.example.entity.subscriber.OTP;
import org.example.entity.subscriber.WebUser;
import org.example.entity.subscriber.dto.WebUserDto;
import org.example.repository.OtpRepository;
import org.example.repository.WebUserRepository;
import org.example.service.WebUserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.example.exception.NotFoundException;

@Service
@RequiredArgsConstructor
public class WebUserServiceImpl implements WebUserService {
    private final WebUserRepository userRepository;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private final OtpRepository otpRepository;


    @Override
    public boolean existByPasswordAndEmail(String password, String email) {
        return userRepository.existsByPasswordAndEmail(password, email);
    }

    @Override
    public WebUser findByPasswordAndEmail(String password, String email) {
        if (!userRepository.existsByPasswordAndEmail(password, email)) {
            throw new NotFoundException(ErrorMessage.DATA_NOT_FOUND);
        }
        return userRepository.findFirstByPasswordAndEmail(password, email);
    }

    @Override
    public boolean existByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public WebUser findByEmail(String email) {
        if (!userRepository.existsByEmail(email)) {
            throw new NotFoundException(ErrorMessage.DATA_NOT_FOUND);
        }
        return userRepository.findFirstByEmail(email);
    }

    @Override
    public void save(WebUserDto webUserDto) {
        OTP otp = otpRepository.findFirstByCode(webUserDto.getOtpTelegram());

        WebUser user = new WebUser();

        user.setEmail(webUserDto.getEmail());
        user.setPassword(passwordEncoder.encode(webUserDto.getPassword()));
        user.setTelegramId(otp.getUserId());
        user.setUsername(otp.getName());
        userRepository.save(user);
    }
}
