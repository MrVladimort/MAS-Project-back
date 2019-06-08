package pl.pjatk.mas.project.control.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.pjatk.mas.project.control.entity.RoleEntity;
import pl.pjatk.mas.project.control.entity.enums.Role;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface RoleDAO extends CrudRepository<RoleEntity, Long> {
    Optional<RoleEntity> findByName(Role roleName);
}
