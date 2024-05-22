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
@Table(name = "button_raw")
public class ButtonRaw {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}
    )
    @JoinColumn(name = "poll_id")
    private PollRaw pollRaw;

    @Column(name = "text")
    private String text;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "callback_data")
    private String callbackData;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ButtonRaw buttonRaw = (ButtonRaw) o;
        return Objects.equals(id, buttonRaw.id) && Objects.equals(text, buttonRaw.text) && Objects.equals(createdAt, buttonRaw.createdAt) && Objects.equals(callbackData, buttonRaw.callbackData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text, createdAt, callbackData);
    }

    @Override
    public String toString() {
        return "ButtonRaw{" +
                "callbackData='" + callbackData + '\'' +
                ", id=" + id +
                ", text='" + text + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
