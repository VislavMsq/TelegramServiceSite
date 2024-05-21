package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.entity.enums.ErrorMessage;
import org.example.entity.subscriber.WebUser;
import org.example.repository.WebUserRepository;
import org.example.service.WebUserService;
import org.springframework.stereotype.Service;
import org.example.exception.NotFoundException;

@Service
@RequiredArgsConstructor
public class WebUserServiceImpl implements WebUserService {
    private final WebUserRepository userRepository;


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
}
