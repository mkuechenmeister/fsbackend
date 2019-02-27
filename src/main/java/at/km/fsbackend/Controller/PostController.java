package at.km.fsbackend.Controller;

import at.km.fsbackend.Exceptions.PostNotFoundException;
import at.km.fsbackend.Exceptions.PostNotValidException;
import at.km.fsbackend.Exceptions.UserNotFoundException;
import at.km.fsbackend.Models.Comment;
import at.km.fsbackend.Models.Post;
import at.km.fsbackend.Services.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    public ResponseEntity<List<Post>> getAllPosts() {
        return ResponseEntity.ok(postService.getAllPosts());
    }

    @GetMapping("/posts/user/{id}")
    public ResponseEntity<List<Post>> postsByUser(@PathVariable Long id) throws UserNotFoundException {
        return ResponseEntity.ok(postService.postsByUser(id));
    }

    @PostMapping("/posts/{id}/addcomment")
    public ResponseEntity<Comment> addCommentForPost(@PathVariable Long id, @RequestBody @Valid Comment comment, BindingResult bindingResult) throws PostNotFoundException, PostNotValidException {
        if (bindingResult.hasErrors()) {
            String message = "";
            for (FieldError fe : bindingResult.getFieldErrors()) {
                message += fe.getField() + ": " + fe.getDefaultMessage();
            }
            throw new PostNotValidException(message);
        } else {
            return ResponseEntity.ok(postService.addCommentForPost(id, comment));
        }
    }
}