package lk.ijse.spring;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
@SpringBootApplication
public class SpringBootAppInitializer {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootAppInitializer.class);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
