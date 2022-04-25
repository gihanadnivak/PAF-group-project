package ceb.ebs.electricitybillingsystem.config;

import ceb.ebs.electricitybillingsystem.controller.UserController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(UserController.class);
    }

}
