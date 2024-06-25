package org.example.entity.subscriber;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "otp")
public class OTP {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "otp")
    private Long code;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "user_name")
    private String name;

    @Column(name = "expiry_time")
    private LocalDateTime expiryTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OTP otp1 = (OTP) o;
        return Objects.equals(id, otp1.id) && Objects.equals(code, otp1.code) && Objects.equals(userId, otp1.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, userId);
    }

    @Override
    public String toString() {
        return "OTP{" +
                "id=" + id +
                ", otp=" + code +
                ", name='" + name +
                ", userId=" + userId +
                ", expiryTime=" + expiryTime +
                '}';
    }
}
