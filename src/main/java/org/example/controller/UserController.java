package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.entity.enums.ErrorMessage;
import org.example.entity.subscriber.dto.WebUserDto;
import org.example.exception.InvalidOtpException;
import org.example.repository.OtpRepository;
import org.example.service.WebUserService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final WebUserService webUserService;
    private final OtpRepository otpRepository;

    @Transactional
    @PostMapping("/new")
    public String register(@RequestBody WebUserDto webUserDto) {
        System.out.println(webUserDto);
        if (!otpRepository.existsByCode(webUserDto.getOtpTelegram())) {
            throw new InvalidOtpException(ErrorMessage.INVALID_OTP);
        } else if (webUserService.existByEmail(webUserDto.getEmail())) {
            throw new InvalidOtpException(ErrorMessage.EMAIL_ALREADY_EXISTS);
        } else {
            webUserService.save(webUserDto);
            otpRepository.deleteByCode(webUserDto.getOtpTelegram());
        }
        return "redirect:/login";
    }
}
