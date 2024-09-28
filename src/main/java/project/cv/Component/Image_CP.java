package project.cv.Component;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Image_CP implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/index/images/**", "/index/profile_img/**")
                .addResourceLocations("file:src/main/resources/static/index/images/", "file:src/main/resources/static/index/profile_img/")
                .setCachePeriod(0);
    }
}
