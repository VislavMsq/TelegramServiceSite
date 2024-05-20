package org.example.repository;

import org.example.entity.temp.Otp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OtpRepository extends JpaRepository<Otp, UUID> {
    boolean existsByOtp(String otp);

    Otp findFirstByOtp(String otp);

    void removeByUserId(String telegramUserId);
}
