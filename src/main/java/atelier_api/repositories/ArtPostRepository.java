package atelier_api.repositories;

import atelier_api.models.ArtPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtPostRepository extends JpaRepository<ArtPost, Long> {
}
