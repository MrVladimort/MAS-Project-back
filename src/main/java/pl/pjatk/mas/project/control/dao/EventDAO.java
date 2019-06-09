package pl.pjatk.mas.project.control.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pjatk.mas.project.control.entity.EventEntity;

public interface EventDAO extends JpaRepository<EventEntity, Long> {
}
