package poc.init;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;
import poc.config.DispatcherServletConfig;
import poc.config.FilterConfig;
import poc.config.ServletConfig;
import poc.config.SpringContextConfig;


@SpringBootApplication
@Import({
        SpringContextConfig.class,
        DispatcherServletConfig.class,
        FilterConfig.class,
        ServletConfig.class,
})
public class Application extends SpringBootServletInitializer
{
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
