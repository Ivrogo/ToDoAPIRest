package dev.ivrogo.todoapirest.Controller;

import dev.ivrogo.todoapirest.DTO.CreateUserDTO;
import dev.ivrogo.todoapirest.DTO.ResponseDTO;
import dev.ivrogo.todoapirest.DTO.UpdateUserDTO;
import dev.ivrogo.todoapirest.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserControllerImpl implements IUserController{
    @Autowired
    private IUserService userService;
    @PostMapping("/NewUser")
    @Override
    public ResponseEntity<ResponseDTO> registerUser(CreateUserDTO createUserDTO) {
        return userService.registerUser(createUserDTO);
    }
    @GetMapping
    @Override
    public ResponseEntity<ResponseDTO> findAll() {
        return userService.findAll();
    }
    @GetMapping("/{id}")
    @Override
    public ResponseEntity<ResponseDTO> findUser(long userId) {
        return userService.findUser(userId);
    }
    @DeleteMapping("/delete/{id}")
    @Override
    public ResponseEntity<ResponseDTO> deleteUser(long userId) {
        return userService.deleteUser(userId);
    }
    @PutMapping("/update/{id}")
    @Override
    public ResponseEntity<ResponseDTO> updateUser(long userId, UpdateUserDTO updateUserDTO) {
        return userService.updateUser(userId, updateUserDTO);
    }
}
