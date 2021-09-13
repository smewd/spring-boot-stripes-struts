package poc.init.config.struts;


import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ServletComponentScan(basePackageClasses = {
		poc.servlet.PackageMarker.class
})
public class StrutsConfig
{
}
