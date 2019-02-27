package at.km.fsbackend;

import at.km.fsbackend.Models.Comment;
import at.km.fsbackend.Models.Post;
import at.km.fsbackend.Models.User;
import at.km.fsbackend.Repositories.CommentRepository;
import at.km.fsbackend.Repositories.PostRepository;
import at.km.fsbackend.Repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FsbackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(FsbackendApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(UserRepository userRepository, PostRepository postRepository, CommentRepository commentRepository) {
               //soll beim Start zum Bootstrapping ausgeführt werden.
        return (args) -> {
            // save a couple of customers
            User u1 = new User();
            u1.setUsername("Claudio");
            userRepository.save(u1);

            User u2 = new User();
            u2.setUsername("Barbara");
            userRepository.save(u2);

            Post p1 = new Post();
            p1.setText("TESTTEST TA ET AE TA SET ASE TASE E TS ");
            p1.setUser(u1);
            postRepository.save(p1);

            Post p2 = new Post();
            p2.setText("TESTTEST TA ET AE TA SET ASE TASE E TS ");
            p2.setUser(u1);
            postRepository.save(p2);

            Post p3 = new Post();
            p3.setText("jj ökjökj föklfj öldkjfödlkj f TS ");
            p3.setUser(u2);
            postRepository.save(p3);



            Comment c1 = new Comment();
            c1.setText("Dies ist ein Kommentar");
            c1.setPost(p1);
            commentRepository.save(c1);
        };
    }
}

