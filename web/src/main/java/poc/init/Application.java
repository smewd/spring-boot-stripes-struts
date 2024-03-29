package poc.init;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import poc.config.DispatcherServletConfig;
import poc.config.FilterConfig;
import poc.config.ServletConfig;


@SpringBootApplication
@Import({
        DispatcherServletConfig.class,
        FilterConfig.class,
        ServletConfig.class,
})
@ImportResource({
        "classpath:spring-context.xml",
        "classpath:spring-struts-actions.xml",
})
public class Application extends SpringBootServletInitializer
{
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
