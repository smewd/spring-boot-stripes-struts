package poc.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
@ComponentScan(basePackageClasses = {
		poc.beans.PackageMarker.class,
		poc.struts.PackageMarker.class,
})
public class SpringContextConfig
{
}
