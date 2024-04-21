package py.com.template.external.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import py.com.template.domain.port.out.ExampleOutPort;
import py.com.template.external.example.ExampleOutPortImpl;

@Configuration
public class ExampleConfig {

    // ::: config

    @Bean
    public ExampleOutPort exampleOutPort(){
        return new ExampleOutPortImpl();
    }

}
