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

    private static final String NOT_FOUND_MESSAGE = "user not found";

    private final UserRepository userRepository;

    public List<UserModel> getAllUsersService() {
        return userRepository.findAll();
    }

    public UserDTO findUserByIdService(String id) {
        var user = userRepository.findById(id);
        if (user.isEmpty()) throw new UserNotFoundException(NOT_FOUND_MESSAGE);
        return fromDTO(user.get());
    }

    public UserDTO saveUserService(UserDTO user) {
        var insertUser = userRepository.save(fromModel(user));
        return fromDTO((insertUser));
    }

    private UserDTO fromDTO(UserModel user) {
        return UserDTO.builder()
                .name(user.getName())
                .lastName(user.getLastName())
                .age(user.getAge())
                .build();
    }

    private UserModel fromModel(UserDTO dto) {
        return UserModel.builder()
                .name(dto.getName())
                .lastName(dto.getLastName())
                .age(dto.getAge())
                .build();
    }
}
