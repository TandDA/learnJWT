package net.gukinon.learnJWT.config;

import jakarta.servlet.MultipartConfigElement;
import net.gukinon.learnJWT.service.FileService;
import net.gukinon.learnJWT.service.Impl.FileServiceImpl;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.util.unit.DataSize;

@Configuration
@EnableWebSecurity
public class ApplicationConfig {
    @Bean
    public FileService getFileService(){
        return new FileServiceImpl();
    }
    @Bean
    MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize(DataSize.ofMegabytes(1));
        factory.setMaxRequestSize(DataSize.ofMegabytes(2));
        return factory.createMultipartConfig();
    }
}
