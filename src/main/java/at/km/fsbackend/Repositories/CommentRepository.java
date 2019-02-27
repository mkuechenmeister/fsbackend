package at.km.fsbackend.Repositories;

import at.km.fsbackend.Models.Comment;
import at.km.fsbackend.Models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPost(Post post);
}
