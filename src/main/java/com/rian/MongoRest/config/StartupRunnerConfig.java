package com.rian.MongoRest.config;

import com.rian.MongoRest.model.CustomerModel;
import com.rian.MongoRest.model.OrderModel;
import com.rian.MongoRest.repository.CustomerRepository;
import com.rian.MongoRest.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class StartupRunnerConfig implements CommandLineRunner {

    private final CustomerRepository customerRepo;
    private final OrderRepository orderRepo;

    @Override
    public void run(String... args) throws Exception {

        customerRepo.deleteAll();
        orderRepo.deleteAll();

        var customer = new CustomerModel(null, "marin", "kitagawa", 22);
        var customer2 = new CustomerModel(null, "rian", "barroso", 19);
        var customer3 = new CustomerModel(null, "lalatina", "justness", 13);

        var order = new OrderModel(null, "cheesecake", 23.50, "with extra cheddar", customer);
        var order2 = new OrderModel(null, "pizza family", 30.00, "with mustard", customer2);
        var order3 = new OrderModel(null, "milkshake 400ml", 12.90, "choco ball", customer);
        var order4 = new OrderModel(null, "chicken wings", 23.10, "with ketchup", customer3);

        customerRepo.saveAll(Arrays.asList(customer, customer2, customer3));
        orderRepo.saveAll(Arrays.asList(order, order2, order3, order4));
    }
}
