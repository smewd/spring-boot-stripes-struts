package poc.init;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;


@SpringBootApplication
//@Import({
//        DispatcherServletConfig.class,
//        ServletConfig.class,
//})
//@ImportResource({
//        "classpath:spring-context.xml",
//        "classpath:spring-struts-actions.xml",
//})
public class Application extends SpringBootServletInitializer
{
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
