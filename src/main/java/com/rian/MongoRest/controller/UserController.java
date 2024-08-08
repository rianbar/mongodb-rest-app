package com.rian.MongoRest.controller;

import com.rian.MongoRest.dto.UserDTO;
import com.rian.MongoRest.model.UserModel;
import com.rian.MongoRest.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/getUsersAll")
    public ResponseEntity<List<UserModel>> getAllUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsersService());
    }

    @GetMapping("/getUser/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable(name = "id") String id) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.findUserByIdService(id));
    }

    @PostMapping("/saveUser")
    public ResponseEntity<UserDTO> saveUser(@RequestBody @Valid UserDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUserService(dto));
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable(value = "id") String id,
                                              @RequestBody @Valid UserDTO dto) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.updateUserService(id, dto));
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable(value = "id") String id) {
        userService.deleteUserService(id);
        return ResponseEntity.noContent().build();
    }
}
