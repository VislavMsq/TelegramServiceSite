package org.example.repository;

import org.example.entity.subscriber.PollRaw;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface PollRawRepository extends JpaRepository<PollRaw, UUID> {
}
