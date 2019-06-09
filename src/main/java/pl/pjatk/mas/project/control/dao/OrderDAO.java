package pl.pjatk.mas.project.control.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pjatk.mas.project.control.entity.OrderEntity;

import java.util.List;

public interface OrderDAO extends JpaRepository<OrderEntity, Long> {
    List<OrderEntity> findAllByClient_Id(Long id);
}
