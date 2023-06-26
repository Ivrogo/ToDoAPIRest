package dev.ivrogo.todoapirest.Controller;

import dev.ivrogo.todoapirest.DTO.CreateTaskDTO;
import dev.ivrogo.todoapirest.DTO.ResponseDTO;
import dev.ivrogo.todoapirest.Service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskControllerImpl implements ITaskController{

    @Autowired
    private ITaskService service;
    @Override
    public ResponseEntity<ResponseDTO> createTask(CreateTaskDTO createTaskDTO) {
        return null;
    }

    @Override
    public ResponseEntity<ResponseDTO> findTask(long id) {
        return null;
    }

    @Override
    public ResponseEntity<ResponseDTO> findAll() {
        return null;
    }
}
