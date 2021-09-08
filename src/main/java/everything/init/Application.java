package everything.init;


import everything.init.config.DispatcherServletConfig;
import everything.init.config.StripesConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;


@SpringBootApplication
@Import({
		DispatcherServletConfig.class,
		StripesConfig.class,
})
public class Application //extends SpringBootServletInitializer
{
	public static void main(String[] args)
	{
		SpringApplication.run(Application.class, args);
	}
}
