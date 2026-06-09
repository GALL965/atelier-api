package atelier_api.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long postId;

    private Long userId;

    private String username;

    @Column(length = 1000)
    private String content;

    private LocalDateTime createdAt =
        LocalDateTime.now();
}
