package poc.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackageClasses = {
        poc.filter.PackageMarker.class
})
public class FilterConfig {
}
