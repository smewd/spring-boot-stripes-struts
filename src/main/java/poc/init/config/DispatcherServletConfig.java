package poc.init.config;


import poc.beans.DummyService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackageClasses = {
		poc.webmvc.controllers.PackageMarker.class,
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
