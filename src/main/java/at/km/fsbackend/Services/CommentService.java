package at.km.fsbackend.Services;

import at.km.fsbackend.Exceptions.PostNotFoundException;
import at.km.fsbackend.Models.Comment;
import at.km.fsbackend.Models.Post;
import at.km.fsbackend.Repositories.CommentRepository;
import at.km.fsbackend.Repositories.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {





        CommentRepository commentRepository;
        PostRepository postRepository;


    public CommentService(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    public List<Comment> getAllComments() {
            return commentRepository.findAll();
        }

        public List<Comment> commentsByPost(Long id) throws PostNotFoundException {

            Optional<Post> op = postRepository.findById(id);
            if (op.isPresent()) {
                return commentRepository.findByPost(op.get());
            } else {
                throw new PostNotFoundException();
            }
        }
    }




