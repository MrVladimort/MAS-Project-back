package pl.pjatk.mas.project.control.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pjatk.mas.project.control.entity.CommentEntity;

public interface CommentDAO extends JpaRepository<CommentEntity, Long> {
}
