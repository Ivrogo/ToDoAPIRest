package dev.ivrogo.todoapirest.Repositories;

import dev.ivrogo.todoapirest.Model.Task;
import dev.ivrogo.todoapirest.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ITaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByUser(User user);
}
