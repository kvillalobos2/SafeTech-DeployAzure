package com.api.safetech.publication.domain.persistence;
import com.api.safetech.publication.domain.model.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
    List<Tag> findByPublicationId(Long publicationId);
}
