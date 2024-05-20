package org.example.entity.subscriber;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
//@Immutable
//@Table(name = "users")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}
    )
    @JoinColumn(name = "channel_id")
    @Transient
    private Object channel;

    @Column(name = "telegram_id")
    @Transient
    private Long telegramId;

    @Column(name = "last_message_time")
    @Transient
    private LocalDateTime lastMessageTime;

    @Column(name = "leave_time")
    private LocalDateTime leaveTime;

    @Column(name = "join_time")
    private LocalDateTime joinTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", telegramId=" + telegramId +
                ", lastMessageTime=" + lastMessageTime +
                ", leaveTime=" + leaveTime +
                ", joinTime=" + joinTime +
                '}';
    }
}