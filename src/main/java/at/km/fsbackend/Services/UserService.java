package at.km.fsbackend.Services;

import at.km.fsbackend.Exceptions.DuplicateUserNameException;
import at.km.fsbackend.Exceptions.UserNotFoundException;
import at.km.fsbackend.Models.Post;
import at.km.fsbackend.Models.User;
import at.km.fsbackend.Repositories.PostRepository;
import at.km.fsbackend.Repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    UserRepository userRepository;
    PostRepository postRepository;

    public UserService(UserRepository userRepository, PostRepository postRepository)
    {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User addUser(User user) throws DuplicateUserNameException {
        if (userRepository.findByUsername(user.getUsername()) == null) {
            return userRepository.save(user);
        } else {
            throw new DuplicateUserNameException();
        }
    }

    public User getUserById(Long id) throws UserNotFoundException {
        Optional<User> opu = userRepository.findById(id);
        if (opu.isPresent()) {
            return opu.get();
        } else {
            throw new UserNotFoundException();
        }
    }

    public Post addPostForUser(Long id, Post post) throws UserNotFoundException
    {
        Optional<User> opuser = userRepository.findById(id);
        if(opuser.isPresent())
        {
            User user = opuser.get();
            post.setUser(user);
            postRepository.save(post);
            return post;
        } else
        {
            throw new UserNotFoundException();
        }
    }
}
