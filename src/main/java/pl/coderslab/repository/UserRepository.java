package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

  User findByEmail(String email);

  User findUserByUsername(String username);

  User findUserByEmail(String email);
}
