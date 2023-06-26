package dev.ivrogo.todoapirest.Repositories;

import dev.ivrogo.todoapirest.Model.Task;
import dev.ivrogo.todoapirest.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ITaskRepository extends JpaRepository<Task, Long> {

    Optional<Task> findByDescription(String description);
}
