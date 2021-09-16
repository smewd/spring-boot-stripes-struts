package poc.config.stripes;


import net.sourceforge.stripes.controller.DispatcherServlet;
import net.sourceforge.stripes.controller.StripesFilter;
import net.sourceforge.stripes.integration.spring.SpringInterceptor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

import javax.servlet.DispatcherType;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Configuration
public class StripesConfig
{
    private static final String URLPATTERN_ACTION = "*.action";
    private static final List<String> URL_MAPPINGS = Collections.singletonList(URLPATTERN_ACTION);

    private static final Class<?> ACTIONRESOLVER_PACKAGEMARKER = poc.stripes.PackageMarker.class;
    private static final String INTERCEPTOR_CLASSES = SpringInterceptor.class.getCanonicalName();
    private static final String LOCALES = "en,sv";

    private static final String STRIPES_DISPATCHERSERVLET_NAME = "stripesDispatcherServlet";


    @Bean
    public ServletRegistrationBean stripesDispatcher()
    {
        final DispatcherServlet dispatcherServlet = new DispatcherServlet();

        ServletRegistrationBean registration = new ServletRegistrationBean();
        registration.setServlet(dispatcherServlet);
        registration.setName(STRIPES_DISPATCHERSERVLET_NAME);
        registration.setLoadOnStartup(1);
        registration.setUrlMappings(URL_MAPPINGS);
        return registration;
    }


    @Bean
    public FilterRegistrationBean stripesFilter()
    {
        final Map<String, String> params = new HashMap<>();
        params.put("ActionResolver.Packages", getPackageName(ACTIONRESOLVER_PACKAGEMARKER));
        params.put("Interceptor.Classes", INTERCEPTOR_CLASSES);
        params.put("LocalePicker.Locales", LOCALES);

        final FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new StripesFilter());
        registration.setServletNames(Collections.singletonList(STRIPES_DISPATCHERSERVLET_NAME));
        registration.setInitParameters(params);
        registration.setDispatcherTypes(DispatcherType.REQUEST, DispatcherType.FORWARD);
        registration.setUrlPatterns(URL_MAPPINGS);
        registration.setOrder(Ordered.HIGHEST_PRECEDENCE + 2);
        return registration;
    }


    private String getPackageName(Class<?> cls)
    {
        return cls.getPackage().getName();
    }
}
