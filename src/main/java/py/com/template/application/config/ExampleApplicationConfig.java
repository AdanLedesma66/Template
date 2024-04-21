package py.com.template.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import py.com.template.domain.port.in.ExampleInPort;
import py.com.template.domain.services.ExampleService;

@Configuration
public class ExampleApplicationConfig {

    // ::: config

    @Bean
    public ExampleInPort exampleInPort(){
        return new ExampleService();
    }

}
