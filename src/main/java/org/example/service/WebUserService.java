package org.example.service;


import org.example.entity.subscriber.WebUser;
import org.example.exception.NotFoundException;

import java.util.Optional;

public interface WebUserService {

    WebUser findByPasswordAndEmail(String password, String email);

    boolean existByPasswordAndEmail(String password, String email);

    boolean existByEmail(String email);

    WebUser findByEmail(String email);

}
