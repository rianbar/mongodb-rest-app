package com.rian.MongoRest.config;

import com.rian.MongoRest.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StartupRunnerConfig implements CommandLineRunner {

    private final CustomerRepository CustomerRepo;

    @Override
    public void run(String... args) throws Exception {
    }
}
