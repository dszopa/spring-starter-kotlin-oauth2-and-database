package com.brainstormer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// This line is one of the most frustrating needed additions I have ever seen.
// It is required that this import be here so that spring realizes to make the beans first.
// No idea why it thinks they don't need to be made... but regardless, this finally works
//@Import({TestDataSourceConfig.class, DataSourceConfig.class})
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}