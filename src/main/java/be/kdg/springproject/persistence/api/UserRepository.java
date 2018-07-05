package be.kdg.springproject.persistence.api;

import be.kdg.springproject.dom.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserByUsername(String username);
}
