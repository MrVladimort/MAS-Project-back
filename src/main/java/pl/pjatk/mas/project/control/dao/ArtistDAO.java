package pl.pjatk.mas.project.control.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pjatk.mas.project.control.entity.ArtistEntity;

public interface ArtistDAO extends JpaRepository<ArtistEntity, Long> {
}
