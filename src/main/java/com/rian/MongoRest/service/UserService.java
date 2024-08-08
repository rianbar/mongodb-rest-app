package com.rian.MongoRest.service;

import com.rian.MongoRest.dto.UserDTO;
import com.rian.MongoRest.exception.errors.UserNotFoundException;
import com.rian.MongoRest.model.UserModel;
import com.rian.MongoRest.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private static final String NOT_FOUND_MESSAGE = "user not found on database!";

    private final UserRepository userRepository;
    private final TransferDataService td;

    public List<UserModel> getAllUsersService() {
        return userRepository.findAll();
    }

    public UserDTO findUserByIdService(String id) {
        var user = userRepository.findById(id);
        if (user.isEmpty()) throw new UserNotFoundException(NOT_FOUND_MESSAGE);
        return td.fromDTO(user.get());
    }

    public UserDTO saveUserService(UserDTO user) {
        var insertUser = userRepository.save(td.fromModel(user));
        return td.fromDTO((insertUser));
    }

    public UserDTO updateUserService(String id, UserDTO dto) {
        var user = userRepository.findById(id);
        if (user.isEmpty()) throw new UserNotFoundException(NOT_FOUND_MESSAGE);
        var updated = userRepository.save(td.updateTo(dto, user.get()));
        return td.fromDTO(updated);
    }

    public void deleteUserService(String id) {
        var user = userRepository.findById(id);
        if (user.isEmpty()) throw new UserNotFoundException(NOT_FOUND_MESSAGE);
        userRepository.delete(user.get());
    }
}
