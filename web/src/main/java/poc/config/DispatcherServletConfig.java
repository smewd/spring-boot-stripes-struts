package poc.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackageClasses = {
		poc.webmvc.controllers.PackageMarker.class,
})
public class DispatcherServletConfig //extends WebMvcConfigurerAdapter
{
//	@Override
//	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
//		super.addResourceHandlers(registry);
//		registry.addResourceHandler("/img/**")
//				.addResourceLocations("classpath:static/img/");
//	}
}
