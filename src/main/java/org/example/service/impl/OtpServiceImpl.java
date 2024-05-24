package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.repository.OtpRepository;
import org.example.service.OtpService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class OtpServiceImpl implements OtpService {

    private final OtpRepository otpRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void deleteOtp(Long otpCode) {
        otpRepository.deleteByCode(otpCode);
    }
}
