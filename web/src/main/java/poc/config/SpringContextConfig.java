package poc.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackageClasses = {
		poc.beans.PackageMarker.class,
		poc.struts.PackageMarker.class,
})
public class SpringContextConfig
{
}
