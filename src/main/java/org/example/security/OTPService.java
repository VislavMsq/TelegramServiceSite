package org.example.security;

import lombok.RequiredArgsConstructor;
import org.example.entity.temp.Otp;
import org.example.repository.OtpRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OTPService {
    private final OtpRepository otpRepository;

    public Otp getUserIdByOTP(String otp) throws Exception {
        if (otpRepository.existsByOtp(otp)) {
            return otpRepository.findFirstByOtp(otp);
        } else {
            throw new Exception("OTP not found");
        }
    }

    public void removeOTP(String telegramUserId) {
        otpRepository.removeByUserId(telegramUserId);
    }
}

