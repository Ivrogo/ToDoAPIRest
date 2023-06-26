package dev.ivrogo.todoapirest.Controller;

import dev.ivrogo.todoapirest.DTO.CreateTaskDTO;
import dev.ivrogo.todoapirest.DTO.ResponseDTO;
import dev.ivrogo.todoapirest.Service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class TaskControllerImpl implements ITaskController{

    @Autowired
    private ITaskService service;
    @Override
    @PostMapping("/newTask")
    public ResponseEntity<ResponseDTO> createTask(CreateTaskDTO createTaskDTO) {
        return service.createTask(createTaskDTO);
    }

    @Override
    @GetMapping("/Tasks/{id}")
    public ResponseEntity<ResponseDTO> findTask(long id) {
        return service.findTask(id);
    }

    @Override
    @GetMapping("/Tasks")
    public ResponseEntity<ResponseDTO> findAll() {
        return service.findAll();
    }
}
