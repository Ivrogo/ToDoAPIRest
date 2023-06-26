package dev.ivrogo.todoapirest.Controller;

import dev.ivrogo.todoapirest.DTO.CreateTaskDTO;
import dev.ivrogo.todoapirest.DTO.ResponseDTO;
import dev.ivrogo.todoapirest.DTO.UpdateTaskDTO;
import dev.ivrogo.todoapirest.Service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskControllerImpl implements ITaskController{

    @Autowired
    private ITaskService taskService;
    @Override
    @PostMapping("/newTask")
    public ResponseEntity<ResponseDTO> createTask(CreateTaskDTO createTaskDTO) {
        return taskService.createTask(createTaskDTO);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO> findTask(long id) {
        return taskService.findTask(id);
    }

    @Override
    @GetMapping()
    public ResponseEntity<ResponseDTO> findAll() {
        return taskService.findAll();
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO> deleteTask(long id) {
        return taskService.deleteTask(id);
    }

    @Override
    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateTask(long id, UpdateTaskDTO updateTaskDTO) {
        return taskService.updateTask(id, updateTaskDTO);
    }
}
