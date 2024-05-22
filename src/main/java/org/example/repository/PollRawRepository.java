package org.example.repository;

import org.example.entity.subscriber.PollRaw;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PollRawRepository extends JpaRepository<PollRaw, UUID> {
}
