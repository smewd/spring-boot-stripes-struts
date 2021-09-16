package poc.init.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import poc.init.config.stripes.StripesConfig;
import poc.init.config.struts.StrutsConfig;


@Configuration
@Import({
//        StripesConfig.class,
//        StrutsConfig.class,
})
public class ServletConfig
{
}
