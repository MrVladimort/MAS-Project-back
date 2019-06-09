package pl.pjatk.mas.project.control.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pjatk.mas.project.control.entity.AttenderEntity;

import java.util.List;

public interface AttenderDAO extends JpaRepository<AttenderEntity, Long> {
    List<AttenderEntity> findAllByClient_Id(Long clientId);
}
