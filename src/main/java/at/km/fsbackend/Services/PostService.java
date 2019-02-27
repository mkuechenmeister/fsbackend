package at.km.fsbackend.Services;

import at.km.fsbackend.Exceptions.PostNotFoundException;
import at.km.fsbackend.Exceptions.UserNotFoundException;
import at.km.fsbackend.Models.Comment;
import at.km.fsbackend.Models.Post;
import at.km.fsbackend.Models.User;
import at.km.fsbackend.Repositories.CommentRepository;
import at.km.fsbackend.Repositories.PostRepository;
import at.km.fsbackend.Repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    PostRepository postRepository;
    UserRepository userRepository;
    CommentRepository commentRepository;

    public PostService(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public List<Post> postsByUser(Long id) throws UserNotFoundException {
        Optional<User> op = userRepository.findById(id);
        if (op.isPresent()) {
            return postRepository.findByUser(op.get());
        } else {
            throw new UserNotFoundException();
        }
    }

    public Comment addCommentForPost(Long id, Comment comment) throws PostNotFoundException {

        Optional<Post> opost = postRepository.findById(id);
        if(opost.isPresent())
        {
            Post post = opost.get();
            comment.setPost(post);
            commentRepository.save(comment);
            return comment;
        } else
        {
            throw new PostNotFoundException();
        }
    }
}
