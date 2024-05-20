package org.example.entity.temp;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table
public class Otp {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "otp")
    private UUID otp;
}
