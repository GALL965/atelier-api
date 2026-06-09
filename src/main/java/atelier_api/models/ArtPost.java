package atelier_api.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class ArtPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long creatorId;

    private String creatorName;

    private String title;

    @Column(length = 2000)
    private String description;

    private String imageUrl;

    private String category;

    private int likes = 0;

    private int loves = 0;

    private int hahas = 0;

    private int wows = 0;

    private int dislikes = 0;

    private LocalDateTime createdAt =
        LocalDateTime.now();
}
