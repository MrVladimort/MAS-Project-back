package pl.pjatk.mas.project.control.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.pjatk.mas.project.control.entity.User;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserDAO
        extends CrudRepository<User, Long> {}
