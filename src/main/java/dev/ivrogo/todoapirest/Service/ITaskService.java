package dev.ivrogo.todoapirest.Service;

import dev.ivrogo.todoapirest.DTO.CreateTaskDTO;
import dev.ivrogo.todoapirest.DTO.ResponseDTO;
import dev.ivrogo.todoapirest.DTO.UpdateTaskDTO;
import org.springframework.http.ResponseEntity;

public interface ITaskService {

    ResponseEntity<ResponseDTO> createTask(CreateTaskDTO createTaskDTO);

    ResponseEntity<ResponseDTO> findTask(long id);

    ResponseEntity<ResponseDTO> findAll();

    ResponseEntity<ResponseDTO> deleteTask(long id);

    ResponseEntity<ResponseDTO> updateTask(long id, UpdateTaskDTO updateTaskDTO);

}
