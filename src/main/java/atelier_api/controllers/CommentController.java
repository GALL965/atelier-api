package atelier_api.controllers;

import atelier_api.models.Comment;
import atelier_api.repositories.CommentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentRepository repository;

    @GetMapping("/{postId}")
    public List<Comment> getCommentsByPost(

        @PathVariable Long postId

    ) {

        return repository
            .findByPostIdOrderByCreatedAtAsc(
                postId
            );
    }

    @PostMapping
    public Comment createComment(

        @RequestBody Comment comment

    ) {

        return repository.save(comment);
    }
}
