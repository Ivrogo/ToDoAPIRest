package dev.ivrogo.todoapirest.Controller;

import dev.ivrogo.todoapirest.DTO.CreateTaskDTO;
import dev.ivrogo.todoapirest.DTO.ResponseDTO;
import org.springframework.http.ResponseEntity;

public interface ITaskController {

    ResponseEntity<ResponseDTO> createTask(CreateTaskDTO createTaskDTO);

    ResponseEntity<ResponseDTO> findTask(long id);

    ResponseEntity<ResponseDTO> findAll();
}
