package poc.config.struts;


import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ServletComponentScan(basePackageClasses = {
		poc.struts.servlet.PackageMarker.class,
})
public class StrutsConfig
{
}
