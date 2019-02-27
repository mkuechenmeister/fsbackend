package at.km.fsbackend.Controller;

import at.km.fsbackend.Exceptions.DuplicateUserNameException;
import at.km.fsbackend.Exceptions.PostNotValidException;
import at.km.fsbackend.Exceptions.UserNotFoundException;
import at.km.fsbackend.Models.Post;
import at.km.fsbackend.Models.User;
import at.km.fsbackend.Repositories.PostRepository;
import at.km.fsbackend.Repositories.UserRepository;
import at.km.fsbackend.Services.PostService;
import at.km.fsbackend.Services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    UserRepository userRepository;
    PostRepository postRepository;
    PostService postService;
    UserService userService;

    public UserController(UserRepository userRepository, PostRepository postRepository, PostService postService, UserService userService) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
        this.postService = postService;
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUser() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping("/user")
    public ResponseEntity<User> addUser(@RequestBody User user) throws DuplicateUserNameException {
        return ResponseEntity.ok(userService.addUser(user));
    }

    @PostMapping("/user/{id}/addpost")
    public ResponseEntity<Post> addPostForUser(@PathVariable Long id, @RequestBody @Valid Post post, BindingResult bindingResult) throws UserNotFoundException, PostNotValidException {
        if (bindingResult.hasErrors()) {
            String message = "";
            for (FieldError fe : bindingResult.getFieldErrors()) {
                message += fe.getField() + ": " + fe.getDefaultMessage();
            }
            throw new PostNotValidException(message);
        } else {
            return ResponseEntity.ok(userService.addPostForUser(id, post));
        }
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) throws UserNotFoundException {
        return ResponseEntity.ok(this.userService.getUserById(id));
    }

}
