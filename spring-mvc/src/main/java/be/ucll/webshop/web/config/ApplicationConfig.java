package be.ucll.webshop.web.config;

import be.ucll.webshop.domain.service.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public ProductService service() {
        return new ProductService("Persistent");
    }

}
