package atelier_api.controllers;

import atelier_api.models.ArtPost;
import atelier_api.repositories.ArtPostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/posts")
public class ArtPostController {

    @Autowired
    private ArtPostRepository repository;

    @GetMapping
    public List<ArtPost> getAllPosts() {

        return repository.findAll();
    }

    @PostMapping
    public ArtPost createPost(
        @RequestBody ArtPost post
    ) {

        return repository.save(post);
    }

    @PutMapping("/{id}/like")
    public ArtPost likePost(
        @PathVariable Long id
    ) {

        ArtPost post =
            repository.findById(id)
                .orElseThrow();

        post.setLikes(
            post.getLikes() + 1
        );

        return repository.save(post);
    }

    @DeleteMapping("/{id}")
    public void deletePost(

        @PathVariable Long id,
        @RequestParam Long userId

    ) {

        ArtPost post =
            repository.findById(id)
                .orElseThrow();

        if (
            post.getCreatorId() == null ||
            !post.getCreatorId().equals(userId)
        ) {

            throw new RuntimeException(
                "You cannot delete this post"
            );
        }

        repository.delete(post);
    }
}
