package pl.pjatk.mas.project.control.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.pjatk.mas.project.control.entity.AdminEntity;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface AdminDAO
        extends CrudRepository<AdminEntity, Long> {
}
