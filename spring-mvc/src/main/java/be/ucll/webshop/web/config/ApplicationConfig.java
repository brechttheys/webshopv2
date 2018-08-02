package be.ucll.webshop.web.config;

import be.ucll.webshop.domain.service.BasketService;
import be.ucll.webshop.domain.service.ProductService;
import be.ucll.webshop.domain.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public ProductService service() {
        return new ProductService("Memory");
    }

    @Bean
    public UserService userservice() { return new UserService("Memory"); }

    @Bean
    public BasketService basketService() { return new BasketService("Memory"); }
}
