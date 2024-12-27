package ru.itmentor.spring.boot_security.demo.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ru.itmentor.spring.boot_security.demo.model.Role;

import java.util.List;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/user").setViewName("user");
    }

    @Bean(name = "allroles")
    public List<Role> allroles() {
        return List.of(new Role(0, "ROLE_USER"), new Role(0, "ROLE_ADMIN"));
    }
}


