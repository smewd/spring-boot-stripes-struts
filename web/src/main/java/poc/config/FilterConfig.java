package poc.config;


import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import poc.filter.AuthorizationFilter;


@Configuration
@ServletComponentScan(basePackageClasses = {
        poc.filter.PackageMarker.class
})
public class FilterConfig
{
    @Bean
    public AuthorizationFilter authorizationFilter()
    {
        return new AuthorizationFilter();
    }
}
