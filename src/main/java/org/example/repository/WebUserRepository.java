package org.example.repository;

import org.example.entity.subscriber.WebUser;
import org.springframework.data.jpa.repository.JpaRepository;


public interface WebUserRepository extends JpaRepository<WebUser, Long> {
    WebUser findFirstByEmail(String email);

    WebUser findFirstByPasswordAndEmail(String password, String email);

    boolean existsByPasswordAndEmail(String password, String email);

    boolean existsByEmail(String email);

}
