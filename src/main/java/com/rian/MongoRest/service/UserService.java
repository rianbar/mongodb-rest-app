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

    public UserDTO updateUserService(String id, UserDTO dto) {
        var user = userRepository.findById(id);
        if (user.isEmpty()) throw new UserNotFoundException(NOT_FOUND_MESSAGE);
        var updated = userRepository.save(updateTo(dto, user.get()));
        return fromDTO(updated);
    }

    public void deleteUserService(String id) {
        var user = userRepository.findById(id);
        if (user.isEmpty()) throw new UserNotFoundException(NOT_FOUND_MESSAGE);
        userRepository.delete(user.get());
    }

    private UserModel updateTo(UserDTO dto, UserModel model) {
        return UserModel.builder()
                .id(model.getId())
                .name(dto.getName())
                .lastName(dto.getLastName())
                .age(dto.getAge())
                .build();
    }

    private UserDTO fromDTO(UserModel user) {
        return UserDTO.builder()
                .id(user.getId())
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
