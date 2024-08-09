package com.rian.MongoRest.service;

import com.rian.MongoRest.dto.CustomerDTO;
import com.rian.MongoRest.exception.errors.CustomerNotFoundException;
import com.rian.MongoRest.model.CustomerModel;
import com.rian.MongoRest.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private static final String NOT_FOUND_MESSAGE = "Customer not found on database!";

    private final CustomerRepository customerRepository;
    private final TransferDataService td;

    public List<CustomerModel> getAllCustomersService() {
        return customerRepository.findAll();
    }

    public CustomerDTO findCustomerByIdService(String id) {
        var user = customerRepository.findById(id);
        if (user.isEmpty()) throw new CustomerNotFoundException(NOT_FOUND_MESSAGE);
        return td.fromDTO(user.get());
    }

    public CustomerDTO saveCustomerService(CustomerDTO user) {
        var insertUser = customerRepository.save(td.fromModel(user));
        return td.fromDTO((insertUser));
    }

    public CustomerDTO updateCustomerService(String id, CustomerDTO dto) {
        var user = customerRepository.findById(id);
        if (user.isEmpty()) throw new CustomerNotFoundException(NOT_FOUND_MESSAGE);
        var updated = customerRepository.save(td.updateTo(dto, user.get()));
        return td.fromDTO(updated);
    }

    public void deleteCustomerService(String id) {
        var user = customerRepository.findById(id);
        if (user.isEmpty()) throw new CustomerNotFoundException(NOT_FOUND_MESSAGE);
        customerRepository.delete(user.get());
    }
}
