package dev.ivrogo.todoapirest.Controller;

import dev.ivrogo.todoapirest.DTO.CreateTaskDTO;
import dev.ivrogo.todoapirest.DTO.ResponseDTO;
import dev.ivrogo.todoapirest.DTO.UpdateTaskDTO;
import dev.ivrogo.todoapirest.Model.Task;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface ITaskController {

    ResponseEntity<ResponseDTO> createTask(@RequestBody CreateTaskDTO createTaskDTO);

    ResponseEntity<ResponseDTO> findTask(@PathVariable long id);

    ResponseEntity<ResponseDTO> findAll();

    ResponseEntity<ResponseDTO> deleteTask(@PathVariable long id);

    ResponseEntity<ResponseDTO> updateTask(@PathVariable long id, @RequestBody UpdateTaskDTO updateTaskDTO);

    ResponseEntity<ResponseDTO> assignTaskToUser(@PathVariable long userId, @RequestBody Task task);
}
