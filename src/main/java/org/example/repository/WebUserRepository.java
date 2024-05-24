package org.example.repository;

import org.example.entity.subscriber.WebUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WebUserRepository extends JpaRepository<WebUser, Long> {
    WebUser findFirstByEmail(String email);

    WebUser findFirstByPasswordAndEmail(String password, String email);

    boolean existsByPasswordAndEmail(String password, String email);

    boolean existsByEmail(String email);

}
