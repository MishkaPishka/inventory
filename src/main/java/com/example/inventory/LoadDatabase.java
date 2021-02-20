package com.example.inventory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
    @Bean
    CommandLineRunner initDatabase(ItemRepository repository) {

        return args -> {
            try{
                log.info("Preloading " + repository.save(new Item("Cocka Cola", 12,1)));
                log.info("Preloading " + repository.save(new Item("Pepsi", 120,21)));

            }
            catch (RuntimeException e) {
                log.info(e.getMessage());
            }
     };
    }
}

