package net.gukinon.learnJWT.config;

import jakarta.servlet.MultipartConfigElement;
import net.gukinon.learnJWT.service.EventService;
import net.gukinon.learnJWT.service.FileService;
import net.gukinon.learnJWT.service.Impl.EventServiceImpl;
import net.gukinon.learnJWT.service.Impl.FileServiceImpl;
import net.gukinon.learnJWT.service.Impl.UserServiceImpl;
import net.gukinon.learnJWT.service.UserService;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.util.unit.DataSize;

@Configuration
@EnableWebSecurity
public class ApplicationConfig {
    @Bean
    MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize(DataSize.ofMegabytes(1));
        factory.setMaxRequestSize(DataSize.ofMegabytes(2));
        return factory.createMultipartConfig();
    }
}
