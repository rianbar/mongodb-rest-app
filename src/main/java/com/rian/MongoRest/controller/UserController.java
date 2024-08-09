package com.rian.MongoRest.controller;

import com.rian.MongoRest.dto.CustomerDTO;
import com.rian.MongoRest.model.CustomerModel;
import com.rian.MongoRest.service.CustomerService;
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

    private final CustomerService customerService;

    @GetMapping("/getUsersAll")
    public ResponseEntity<List<CustomerModel>> getAllCustomers() {
        return ResponseEntity.status(HttpStatus.OK).body(customerService.getAllCustomersService());
    }

    @GetMapping("/getUser/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable(name = "id") String id) {
        return ResponseEntity.status(HttpStatus.OK).body(customerService.findCustomerByIdService(id));
    }

    @PostMapping("/saveUser")
    public ResponseEntity<CustomerDTO> saveCustomer(@RequestBody @Valid CustomerDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.saveCustomerService(dto));
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable(value = "id") String id,
                                                  @RequestBody @Valid CustomerDTO dto) {
        return ResponseEntity.status(HttpStatus.OK).body(customerService.updateCustomerService(id, dto));
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable(value = "id") String id) {
        customerService.deleteCustomerService(id);
        return ResponseEntity.noContent().build();
    }
}
