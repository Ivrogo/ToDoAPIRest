package dev.ivrogo.todoapirest.Repositories;

import dev.ivrogo.todoapirest.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
