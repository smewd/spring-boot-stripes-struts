package everything.init.config;


import net.sourceforge.stripes.controller.DispatcherServlet;
import net.sourceforge.stripes.controller.StripesFilter;
import net.sourceforge.stripes.integration.spring.SpringInterceptor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

import javax.servlet.DispatcherType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Configuration
public class StripesConfig
{
	private static final String URL_PATTERN = "*.action";


	@Bean
	public ServletRegistrationBean stripesServlet()
	{
		DispatcherServlet servlet = new DispatcherServlet();

		ServletRegistrationBean registration = new ServletRegistrationBean();
		registration.setServlet(servlet);
		registration.setLoadOnStartup(1);
		registration.addUrlMappings(URL_PATTERN);
		return registration;
	}


	@Bean
	public FilterRegistrationBean stripesFilter(List<String> urlPatternsForStripesFilter)
	{
		Map<String, String> params = new HashMap<>();
		params.put("Interceptor.Classes", SpringInterceptor.class.getCanonicalName());
		params.put("ActionResolver.Packages", "everything.stripes");

		final FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(new StripesFilter());
		registration.setInitParameters(params);
		registration.setUrlPatterns(urlPatternsForStripesFilter());
		registration.setDispatcherTypes(DispatcherType.REQUEST, DispatcherType.FORWARD);
		registration.setOrder(Ordered.HIGHEST_PRECEDENCE + 2);
		return registration;
	}


	@Bean
	public List<String> urlPatternsForStripesFilter()
	{
		final List<String> urlPatterns = new ArrayList<>();
		urlPatterns.add(URL_PATTERN);
		return urlPatterns;
	}
}
