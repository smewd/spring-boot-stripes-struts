package poc.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import poc.config.stripes.StripesConfig;
import poc.config.struts.StrutsConfig;


@Configuration
@Import({
        StripesConfig.class,
        StrutsConfig.class,
})
public class ServletConfig
{
}
