package com.api.safetech.publication.domain.persistence;
import com.api.safetech.publication.domain.model.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>{
    List<Comment> findByPublicationId(Long publicationId);
    List<Comment> findByUserId(Long userId);
}
