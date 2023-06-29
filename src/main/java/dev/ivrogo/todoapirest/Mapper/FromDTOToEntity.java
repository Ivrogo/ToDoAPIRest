package dev.ivrogo.todoapirest.Mapper;

import dev.ivrogo.todoapirest.DTO.CreateTaskDTO;
import dev.ivrogo.todoapirest.DTO.CreateUserDTO;
import dev.ivrogo.todoapirest.DTO.UpdateTaskDTO;
import dev.ivrogo.todoapirest.Model.Task;
import dev.ivrogo.todoapirest.Model.User;

public class FromDTOToEntity {

    public static Task fromDTOToEntity(CreateTaskDTO createTaskDTO) {
        Task task = new Task();
        task.setDescription(createTaskDTO.getDescription());

        return task;
    }

    public static User fromDTOToEntity(CreateUserDTO createUserDTO) {
        User user = new User();
        user.setEmail(createUserDTO.getEmail());
        user.setPassword(createUserDTO.getPassword());

        return user;
    }

    public static void updateEntityFromDTO(Task taskToUpdate, UpdateTaskDTO updateTaskDTO) {
        taskToUpdate.setDescription(updateTaskDTO.getDescription());
    }
}
