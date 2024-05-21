package org.example.entity.temp;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table
@Getter
@Setter
public class Otp {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "otp")
    private Long code;

    @Column(name = "user_name")
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Otp otp = (Otp) o;
        return Objects.equals(id, otp.id) && Objects.equals(userId, otp.userId) && Objects.equals(code, otp.code) && Objects.equals(name, otp.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, code, name);
    }

    @Override
    public String toString() {
        return "Otp{" +
                "id=" + id +
                ", userId=" + userId +
                ", code=" + code +
                ", name='" + name + '\'' +
                '}';
    }
}
