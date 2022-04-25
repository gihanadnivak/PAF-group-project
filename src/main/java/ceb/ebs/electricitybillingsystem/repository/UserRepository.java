package ceb.ebs.electricitybillingsystem.repository;

import ceb.ebs.electricitybillingsystem.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    @Query(value = "SELECT U FROM User U where U.id = :id and U.active = true")
    Optional<User> findUserById(Long id);

    @Query(value = "SELECT U FROM User U where U.active = true")
    Iterable<User> findAll();

}
