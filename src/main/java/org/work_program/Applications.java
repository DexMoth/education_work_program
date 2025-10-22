package org.work_program;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "org.work_program.models")
@EnableJpaRepositories(basePackages = "org.work_program.repositories")
public class Applications {

    public static void main(String[] args) {
        SpringApplication.run(Applications.class);
    }
}