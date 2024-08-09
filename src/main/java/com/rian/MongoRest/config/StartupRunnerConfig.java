package com.rian.MongoRest.config;

import com.rian.MongoRest.model.CustomerModel;
import com.rian.MongoRest.model.OrderModel;
import com.rian.MongoRest.repository.CustomerRepository;
import com.rian.MongoRest.repository.OrderRepository;
import com.rian.MongoRest.service.TransferDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class StartupRunnerConfig implements CommandLineRunner {

    private final CustomerRepository customerRepo;
    private final OrderRepository orderRepo;
    private final TransferDataService td;

    @Override
    public void run(String... args) throws Exception {

        customerRepo.deleteAll();
        orderRepo.deleteAll();

        var customer = new CustomerModel(null, "marin", "kitagawa", 22);
        var customer2 = new CustomerModel(null, "rian", "barroso", 19);

        customerRepo.save(customer);
        customerRepo.save(customer2);

        var order = new OrderModel(null, "cheesecake", 23.50,
                "with extra cheddar", td.fromDTO(customer));
        var order3 = new OrderModel(null, "milkshake 400ml", 12.90,
                "choco ball", td.fromDTO(customer));
        var order4 = new OrderModel(null, "chicken wings", 23.10,
                "with ketchup", td.fromDTO(customer2));

        orderRepo.saveAll(List.of(order, order3, order4));

        customer.getOrders().addAll(List.of(order, order3));
        customer2.getOrders().add(order4);

        customerRepo.save(customer);
        customerRepo.save(customer2);
    }
}
