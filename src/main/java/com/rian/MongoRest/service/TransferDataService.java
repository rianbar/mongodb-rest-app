package com.rian.MongoRest.service;

import com.rian.MongoRest.dto.CustomerDTO;
import com.rian.MongoRest.model.CustomerModel;
import org.springframework.stereotype.Service;

@Service
public class TransferDataService {

    public CustomerModel updateTo(CustomerDTO dto, CustomerModel model) {
        return CustomerModel.builder()
                .id(model.getId())
                .name(dto.getName())
                .lastName(dto.getLastName())
                .age(dto.getAge())
                .build();
    }

    public CustomerDTO fromDTO(CustomerModel user) {
        return CustomerDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .lastName(user.getLastName())
                .age(user.getAge())
                .build();
    }

    public CustomerModel fromModel(CustomerDTO dto) {
        return CustomerModel.builder()
                .name(dto.getName())
                .lastName(dto.getLastName())
                .age(dto.getAge())
                .build();
    }
}
