package everything.init.config;


import everything.beans.DummyService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackageClasses = {
		everything.webmvc.controllers.PackageMarker.class,
})
public
class DispatcherServletConfig
{
	@Bean
	public DummyService dummyService()
	{
		return new DummyService();
	}
}
