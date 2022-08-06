package tech.abb.phonebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.abb.phonebook.model.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByUserId(Integer userId);
    Integer deleteUserByUserId(Integer userId);
}
