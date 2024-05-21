package org.example.entity.subscriber;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "web_users")
public class WebUser {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "telegram_id")
    private Long telegramId;

    @Column(name = "username")
    private String username;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WebUser webUser = (WebUser) o;
        return Objects.equals(id, webUser.id) && Objects.equals(email, webUser.email) && Objects.equals(password, webUser.password) && Objects.equals(telegramId, webUser.telegramId) && Objects.equals(username, webUser.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password, telegramId, username);
    }

    @Override
    public String toString() {
        return "WebUser{" +
                "email='" + email + '\'' +
                ", id=" + id +
                ", password='" + password + '\'' +
                ", telegramId=" + telegramId +
                ", username='" + username + '\'' +
                '}';
    }
}
