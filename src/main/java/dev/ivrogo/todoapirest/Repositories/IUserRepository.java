package dev.ivrogo.todoapirest.Repositories;

import dev.ivrogo.todoapirest.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
