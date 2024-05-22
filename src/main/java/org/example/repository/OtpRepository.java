package org.example.repository;

import org.example.entity.subscriber.OTP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OtpRepository extends JpaRepository<OTP, UUID> {
    boolean existsByCode(Long code);

    OTP findFirstByCode(Long code);

    void removeByCode(Long code);

    void deleteByCode(Long telegramId);
}
