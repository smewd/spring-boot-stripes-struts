package poc.init;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;
import poc.init.config.DispatcherServletConfig;
import poc.init.config.stripes.StripesConfig;


@SpringBootApplication
@Import({
		DispatcherServletConfig.class,
		StripesConfig.class,
})
public class Application extends SpringBootServletInitializer
{
	public static void main(String[] args)
	{
		SpringApplication.run(Application.class, args);
	}
}
