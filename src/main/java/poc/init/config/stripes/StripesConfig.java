package poc.init.config.stripes;


import lombok.RequiredArgsConstructor;
import net.sourceforge.stripes.controller.DynamicMappingFilter;
import net.sourceforge.stripes.controller.StripesFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.Ordered;

import java.util.Collections;
import java.util.List;

import static javax.servlet.DispatcherType.ERROR;
import static javax.servlet.DispatcherType.FORWARD;
import static javax.servlet.DispatcherType.INCLUDE;
import static javax.servlet.DispatcherType.REQUEST;


@Configuration
@Import(StripesProperties.class)
@RequiredArgsConstructor
public class StripesConfig
{
	private static final List<String> URL_PATTERNS = Collections.singletonList("*.action");

	private final StripesProperties properties;


	@Bean
	public FilterRegistrationBean stripesFilter()
	{
		final ParamMap<String, String> params = new ParamMap<>();
		params.defaultIfEmpty("ActionResolver.Packages", properties.getActionResolverPackages(),
				StripesClassesScanner::scanForActionBeans);
		params.defaultIfEmpty("Extension.Packages", properties.getExtensionPackages(),
				() -> "net.sourceforge.stripes.integration.spring");
		params.putIfNotEmpty("Interceptor.Classes", properties.getInterceptors());
		params.putIfNotEmpty("LocalePicker.Locales", properties.getLocales());
		params.putIfNotEmpty("Stripes.DebugMode", properties.getDebugMode());
		params.defaultIfEmpty("VFS.Classes", properties.getVfsClasses(),
				SpringBootVFS.class::getCanonicalName);

		final FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(new StripesFilter());
		registration.setInitParameters(params);
		registration.setUrlPatterns(URL_PATTERNS);
		registration.setDispatcherTypes(REQUEST);
		registration.setOrder(Ordered.HIGHEST_PRECEDENCE + 2);
		return registration;
	}


	@Bean
	public FilterRegistrationBean stripesDynamicFilter()
	{
		final FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(new DynamicMappingFilter());
		registration.setUrlPatterns(URL_PATTERNS);
		registration.setDispatcherTypes(REQUEST, INCLUDE, FORWARD, ERROR);
		registration.setOrder(Ordered.LOWEST_PRECEDENCE);
		return registration;
	}
}
