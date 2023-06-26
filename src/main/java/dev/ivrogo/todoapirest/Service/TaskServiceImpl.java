package dev.ivrogo.todoapirest.Service;

import dev.ivrogo.todoapirest.DTO.CreateTaskDTO;
import dev.ivrogo.todoapirest.DTO.ResponseDTO;
import dev.ivrogo.todoapirest.Mapper.FromDTOToEntity;
import dev.ivrogo.todoapirest.Model.Task;
import dev.ivrogo.todoapirest.Repositories.ITaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements ITaskService{
    @Autowired
    private ITaskRepository repository;
    @Override
    public ResponseEntity<ResponseDTO> createTask(CreateTaskDTO createTaskDTO) {
        ResponseDTO responseDTO = new ResponseDTO();
        try {
            if (createTaskDTO.getDescription().isEmpty()) {
                responseDTO.setMessage("The field cannot be empty");
                return new ResponseEntity<>(responseDTO, HttpStatus.NO_CONTENT);
            }
            //We create the object
            Optional<Task> foundTasks = repository.findByDescription(createTaskDTO.getDescription());
            if (!foundTasks.isEmpty()) {
                responseDTO.setMessage("The task already exists");
                return new ResponseEntity<>(responseDTO, HttpStatus.CONFLICT);
            } else {
                Task task = repository.save(FromDTOToEntity.fromDTOToEntity(createTaskDTO));
                responseDTO.setMessage("Task saved successfully");
                responseDTO.setValue(task);
                return new ResponseEntity<>(responseDTO, HttpStatus.OK);
            }
        } catch (Exception e) {
            responseDTO.setMessage("Error");
            return new ResponseEntity<>(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<ResponseDTO> findTask(long id) {
        ResponseDTO response = new ResponseDTO();
        try {
            Optional<Task> foundTask = repository.findById(id);
            if (foundTask.isEmpty()) {
                response.setMessage("The task doesnt exists");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            } else {
                response.setMessage("Task Found");
                response.setValue(foundTask);
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
        } catch (Exception e) {
            response.setMessage("Error");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<ResponseDTO> findAll() {
        ResponseDTO response = new ResponseDTO();
        try {
            List<Task> foundTasks = repository.findAll();
            if (foundTasks.isEmpty()) {
                response.setMessage("There's no tasks to be found");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            } else {
                response.setMessage("Found Tasks");
                response.setValue(foundTasks);
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
        } catch (Exception e) {
            response.setMessage("Error");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
