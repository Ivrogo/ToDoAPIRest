package dev.ivrogo.todoapirest.Service;

import dev.ivrogo.todoapirest.DTO.CreateUserDTO;
import dev.ivrogo.todoapirest.DTO.ResponseDTO;
import dev.ivrogo.todoapirest.DTO.UpdateUserDTO;
import dev.ivrogo.todoapirest.Mapper.FromDTOToEntity;
import dev.ivrogo.todoapirest.Model.User;
import dev.ivrogo.todoapirest.Repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService{
    @Autowired
    private IUserRepository userRepository;
    @Override
    public ResponseEntity<ResponseDTO> registerUser(CreateUserDTO createUserDTO) {
        ResponseDTO responseDTO = new ResponseDTO();
        try {
            if (createUserDTO.getEmail().isEmpty() && createUserDTO.getPassword().isEmpty()) {
                responseDTO.setMessage("The fields cannot be empty");
                return new ResponseEntity<>(responseDTO, HttpStatus.NO_CONTENT);
            }
            //We create the user
            Optional<User> foundUser = userRepository.findByEmail(createUserDTO.getEmail());
            if(!foundUser.isEmpty()) {
                responseDTO.setMessage("A user with that email already exists");
                return new ResponseEntity<>(responseDTO, HttpStatus.CONFLICT);
            } else {
                BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
                createUserDTO.setPassword(bCryptPasswordEncoder.encode(createUserDTO.getPassword()));
                User user = userRepository.save(FromDTOToEntity.fromDTOToEntity(createUserDTO));
                responseDTO.setMessage("User registered successfully");
                responseDTO.setValue(user);
                return new ResponseEntity<>(responseDTO, HttpStatus.OK);
            }
        } catch (Exception e) {
            responseDTO.setMessage("Error");
            return new ResponseEntity<>(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<ResponseDTO> findAll() {
        ResponseDTO responseDTO = new ResponseDTO();
        try {
            List<User> userList = userRepository.findAll();
            if (userList.isEmpty()) {
                responseDTO.setMessage("There's no users registered in the database");
                return  new ResponseEntity<>(responseDTO, HttpStatus.NOT_FOUND);
            } else {
                responseDTO.setMessage("Showing all the registered users");
                responseDTO.setValue(userList);
                return new ResponseEntity<>(responseDTO, HttpStatus.OK);
            }
        } catch (Exception e) {
            responseDTO.setMessage("Error");
            return new ResponseEntity<>(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<ResponseDTO> findUser(long userId) {
        ResponseDTO responseDTO = new ResponseDTO();
        try {
            Optional<User> foundUser = userRepository.findById(userId);
            if(foundUser.isEmpty()) {
                responseDTO.setMessage("There's no user registered with that id");
                return new ResponseEntity<>(responseDTO, HttpStatus.NOT_FOUND);
            } else {
                responseDTO.setMessage("Showing the registered user");
                responseDTO.setValue(foundUser);
                return  new ResponseEntity<>(responseDTO, HttpStatus.OK);
            }
        } catch (Exception e) {
            responseDTO.setMessage("Error");
            return new ResponseEntity<>(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<ResponseDTO> deleteUser(long userId) {
        ResponseDTO responseDTO = new ResponseDTO();
        try {
            Optional<User> foundUser = userRepository.findById(userId);
            if(foundUser.isEmpty()) {
                responseDTO.setMessage("The user does not exist");
                return  new ResponseEntity<>(responseDTO, HttpStatus.NOT_FOUND);
            } else {
                userRepository.delete(foundUser.get());
                responseDTO.setMessage("User deleted Successfully");
                return new ResponseEntity<>(responseDTO, HttpStatus.OK);
            }
        } catch (Exception e) {
            responseDTO.setMessage("Error");
            return new ResponseEntity<>(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<ResponseDTO> updateUser(long userId, UpdateUserDTO updateUserDTO) {
        ResponseDTO responseDTO = new ResponseDTO();
        try {
            Optional<User> foundUser = userRepository.findById(userId);
            if(foundUser.isEmpty()) {
                responseDTO.setMessage("The user does not exist");
                return new ResponseEntity<>(responseDTO, HttpStatus.NOT_FOUND);
            } else {
                FromDTOToEntity.updateEntityFromDTO(foundUser.get(), updateUserDTO);
                User updatedUser = userRepository.save(foundUser.get());
                responseDTO.setMessage("User updated successfully");
                responseDTO.setValue(updatedUser);
                return new ResponseEntity<>(responseDTO, HttpStatus.OK);
            }
        } catch (Exception e) {
            responseDTO.setMessage("Error");
            return new ResponseEntity<>(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
