package dev.ivrogo.todoapirest.Controller;

import dev.ivrogo.todoapirest.DTO.CreateUserDTO;
import dev.ivrogo.todoapirest.DTO.ResponseDTO;
import dev.ivrogo.todoapirest.DTO.UpdateUserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface IUserController {

    ResponseEntity<ResponseDTO> registerUser(@RequestBody CreateUserDTO createUserDTO);

    ResponseEntity<ResponseDTO> findAll();

    ResponseEntity<ResponseDTO> findUser(@PathVariable long userId);

    ResponseEntity<ResponseDTO> deleteUser(@PathVariable long userId);

    ResponseEntity<ResponseDTO> updateUser(@PathVariable long userId, @RequestBody UpdateUserDTO updateUserDTO);
}
