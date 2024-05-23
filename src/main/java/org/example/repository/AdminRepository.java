package org.example.repository;

import org.example.entity.subscriber.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AdminRepository extends JpaRepository<Admin, UUID> {
    Admin findFirstByTelegramId(Long telegramId);
}
