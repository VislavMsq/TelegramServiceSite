package org.example.repository;

import org.example.entity.subscriber.Button;
import org.example.entity.subscriber.ButtonUserLink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ButtonUserLinkRepository extends JpaRepository<ButtonUserLink, UUID> {
    List<ButtonUserLink> findAllByButton(Button button);
}
