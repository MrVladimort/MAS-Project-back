package pl.pjatk.mas.project.control.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pjatk.mas.project.control.entity.LocalizationEntity;

public interface LocalizationDAO extends JpaRepository<LocalizationEntity, Long> {
}
