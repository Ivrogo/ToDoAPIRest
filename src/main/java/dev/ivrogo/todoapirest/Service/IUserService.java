package dev.ivrogo.todoapirest.Service;

import dev.ivrogo.todoapirest.DTO.CreateUserDTO;
import dev.ivrogo.todoapirest.DTO.ResponseDTO;
import dev.ivrogo.todoapirest.DTO.UpdateUserDTO;
import org.springframework.http.ResponseEntity;

public interface IUserService {

    ResponseEntity<ResponseDTO> registerUser(CreateUserDTO createUserDTO);

    ResponseEntity<ResponseDTO> findAll();

    ResponseEntity<ResponseDTO> findUser(long userId);

    ResponseEntity<ResponseDTO> deleteUser(long userId);

    ResponseEntity<ResponseDTO> updateUser(long userId, UpdateUserDTO updateUserDTO);
}
