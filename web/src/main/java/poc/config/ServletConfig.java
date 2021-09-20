package poc.config;


import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import poc.config.stripes.StripesConfig;


@Configuration
@ServletComponentScan(basePackageClasses = {
        poc.struts.servlet.PackageMarker.class,
})
@Import({
        StripesConfig.class,
})
public class ServletConfig
{
}
