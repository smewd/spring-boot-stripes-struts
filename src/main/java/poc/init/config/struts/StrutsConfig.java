package poc.init.config.struts;


import lombok.RequiredArgsConstructor;
import net.sourceforge.stripes.controller.DynamicMappingFilter;
import net.sourceforge.stripes.controller.StripesFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.Ordered;
import poc.init.config.stripes.ParamMap;
import poc.init.config.stripes.SpringBootVFS;
import poc.init.config.stripes.StripesClassesScanner;
import poc.init.config.stripes.StripesProperties;
import poc.servlet.BootActionServlet;

import java.util.Collections;
import java.util.List;

import static javax.servlet.DispatcherType.ERROR;
import static javax.servlet.DispatcherType.FORWARD;
import static javax.servlet.DispatcherType.INCLUDE;
import static javax.servlet.DispatcherType.REQUEST;


@Configuration
@ServletComponentScan(basePackageClasses = {
		poc.servlet.PackageMarker.class
})
public class StrutsConfig
{
}
