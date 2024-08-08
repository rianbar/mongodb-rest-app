package com.rian.MongoRest.service;

import com.rian.MongoRest.dto.UserDTO;
import com.rian.MongoRest.model.UserModel;
import org.springframework.stereotype.Service;

@Service
public class TransferDataService {

    public UserModel updateTo(UserDTO dto, UserModel model) {
        return UserModel.builder()
                .id(model.getId())
                .name(dto.getName())
                .lastName(dto.getLastName())
                .age(dto.getAge())
                .build();
    }

    public UserDTO fromDTO(UserModel user) {
        return UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .lastName(user.getLastName())
                .age(user.getAge())
                .build();
    }

    public UserModel fromModel(UserDTO dto) {
        return UserModel.builder()
                .name(dto.getName())
                .lastName(dto.getLastName())
                .age(dto.getAge())
                .build();
    }
}
