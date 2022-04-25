package ceb.ebs.electricitybillingsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ElectricityBillingSystem extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ElectricityBillingSystem.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(ElectricityBillingSystem.class, args);
    }

}
