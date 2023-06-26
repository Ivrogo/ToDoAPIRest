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
                repository.save(FromDTOToEntity.fromDTOToEntity(createTaskDTO));
                responseDTO.setMessage("Task saved successfully");
                return new ResponseEntity<>(responseDTO, HttpStatus.OK);
            }
        } catch (Exception e) {
            responseDTO.setMessage("Error");
            return new ResponseEntity<>(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
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
