package at.km.fsbackend.Controller;

import at.km.fsbackend.Exceptions.PostNotFoundException;
import at.km.fsbackend.Exceptions.PostNotValidException;
import at.km.fsbackend.Exceptions.UserNotFoundException;
import at.km.fsbackend.Models.Comment;
import at.km.fsbackend.Models.Post;
import at.km.fsbackend.Services.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }



        @GetMapping("/comments")
        public ResponseEntity<List<Comment>> getAllComments() {
            return ResponseEntity.ok(commentService.getAllComments());
        }

        @GetMapping("/comments/posts/{id}")
        public ResponseEntity<List<Comment>> postsByUser(@PathVariable Long id) throws PostNotFoundException {
            return ResponseEntity.ok(commentService.commentsByPost(id));
        }



    }

