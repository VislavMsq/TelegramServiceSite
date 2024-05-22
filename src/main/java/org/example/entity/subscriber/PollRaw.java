package org.example.entity.subscriber;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "raw_polls")
public class PollRaw {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "code")
    private UUID code;

    @Column(name = "text")
    private String text;

    @OneToMany(
            mappedBy = "pollRaw",
            cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
            fetch = FetchType.LAZY
    )
    private List<ButtonRaw> buttons;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PollRaw pollRaw = (PollRaw) o;
        return Objects.equals(id, pollRaw.id) && Objects.equals(createdAt, pollRaw.createdAt) && Objects.equals(code, pollRaw.code) && Objects.equals(text, pollRaw.text) && Objects.equals(buttons, pollRaw.buttons);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdAt, code, text, buttons);
    }

    @Override
    public String toString() {
        return "PollRaw{" +
                "buttons=" + buttons +
                ", id=" + id +
                ", createdAt=" + createdAt +
                ", code=" + code +
                ", text='" + text + '\'' +
                '}';
    }
}
