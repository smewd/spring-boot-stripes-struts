package poc.init.config;


import lombok.RequiredArgsConstructor;
import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.controller.DynamicMappingFilter;
import net.sourceforge.stripes.controller.StripesFilter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.Ordered;
import org.springframework.core.type.filter.AssignableTypeFilter;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import static javax.servlet.DispatcherType.ERROR;
import static javax.servlet.DispatcherType.FORWARD;
import static javax.servlet.DispatcherType.INCLUDE;
import static javax.servlet.DispatcherType.REQUEST;


@Configuration
@Import(StripesProperties.class)
@RequiredArgsConstructor
public class StripesConfig
{
	private static final String URL_PATTERN = "*.action";

	private final StripesProperties properties;


	@Bean("urlPatternsForStripesFilter")
	public List<String> urlPatternsForStripesFilter()
	{
		final List<String> urlPatterns = new ArrayList<>();
		urlPatterns.add(URL_PATTERN);
		return urlPatterns;
	}


	@Bean(name = "stripesFilter")
	public FilterRegistrationBean stripesFilter(
			@Qualifier("urlPatternsForStripesFilter") final List<String> urlPatternsForStripesFilter)
	{
		final Map<String, String> params = new HashMap<>();
		setActionResolverPackages(params, properties.getActionResolverPackages());
		putIfNotEmpty(params, "ActionBeanPropertyBinder.Class", properties.getActionBeanPropertyBinder());
		putIfNotEmpty(params, "ActionBeanContext.Class", properties.getActionBeanContext());
		putIfNotEmpty(params, "ActionBeanContextFactory.Class", properties.getActionBeanContextFactory());
		putIfNotEmpty(params, "ActionResolver.Class", properties.getActionResolver());
		putIfNotEmpty(params, "Configuration.Class", properties.getConfiguration());
		putIfNotEmpty(params, "CoreInterceptor.Classes", properties.getCoreInterceptorClasses());
		putIfNotEmpty(params, "DelegatingExceptionHandler.Packages", properties.getDelegatingExceptionHandlerPackages());
		putIfNotEmpty(params, "ExceptionHandler.Class", properties.getExceptionHandler());
		defaultIfEmpty(params, "Extension.Packages", properties.getExtensionPackages(),
				() -> "net.sourceforge.stripes.integration.spring");
		putIfNotEmpty(params, "FormatterFactory.Class", properties.getFormatterFactory());
		putIfNotEmpty(params, "Interceptor.Classes", properties.getInterceptors());
		putIfNotEmpty(params, "LocalePicker.Class", properties.getLocalePicker());
		putIfNotEmpty(params, "LocalePicker.Locales", properties.getLocales());
		putIfNotEmpty(params, "LocalizationBundleFactory.Class", properties.getLocalizationBundleFactory());
		putIfNotEmpty(params, "LocalizationBundleFactory.ErrorMessageBundle", properties.getErrorMessageBundle());
		putIfNotEmpty(params, "LocalizationBundleFactory.FieldNameBundle", properties.getFieldNameBundle());
		putIfNotEmpty(params, "MultipartWrapper.Class", properties.getMultipartWrapper());
		putIfNotEmpty(params, "MultipartWrapperFactory.Class", properties.getMultipartWrapperFactory());
		putIfNotEmpty(params, "FileUpload.MaximumPostSize", properties.getFileUploadMaximumPostSize());
		putIfNotEmpty(params, "PopulationStrategy.Class", properties.getPopulationStrategy());
		putIfNotEmpty(params, "TagErrorRendererFactory.Class", properties.getTagErrorRendererFactory());
		putIfNotEmpty(params, "TypeConverterFactory.Class", properties.getTypeConverterFactory());
		putIfNotEmpty(params, "Stripes.DebugMode", properties.getDebugMode());
		putIfNotEmpty(params, "Stripes.EncryptionKey", properties.getEncryptionKey());
		putIfNotEmpty(params, "Stripes.HtmlMode", properties.getHtmlMode());
		defaultIfEmpty(params, "VFS.Classes", properties.getVfsClasses(),
				() -> poc.init.config.SpringBootVFS.class.getCanonicalName());
		for (final Map.Entry<String, String> customConf : properties.getCustomConf().entrySet())
		{
			putIfNotEmpty(params, customConf.getKey(), customConf.getValue());
		}

		final FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(new StripesFilter());
		registration.setInitParameters(params);
		registration.setUrlPatterns(urlPatternsForStripesFilter);
		registration.setDispatcherTypes(REQUEST);
		registration.setOrder(Ordered.HIGHEST_PRECEDENCE + 2);
		return registration;
	}


	@Bean("urlPatternsForStripesDynamicFilter")
	public List<String> urlPatternsForStripesDynamicFilter()
	{
		final List<String> urlPatterns = new ArrayList<>();
		urlPatterns.add("/*");
		return urlPatterns;
	}


	@Bean(name = "stripesDynamicFilter")
	public FilterRegistrationBean stripesDynamicFilter(
			@Qualifier("urlPatternsForStripesDynamicFilter") final List<String> urlPatternsForStripesDynamicFilter)
	{
		final FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(new DynamicMappingFilter());
		registration.setUrlPatterns(urlPatternsForStripesDynamicFilter);
		registration.setDispatcherTypes(REQUEST, INCLUDE, FORWARD, ERROR);
		registration.setOrder(Ordered.LOWEST_PRECEDENCE);
		return registration;
	}


	void setActionResolverPackages(final Map<String, String> params, final String value)
	{
		if (StringUtils.isEmpty(value))
		{
			putIfNotEmpty(params, "ActionResolver.Packages", locateActionResolverPackages());
		}
		else
		{
			putIfNotEmpty(params, "ActionResolver.Packages", value);
		}
	}


	String locateActionResolverPackages()
	{
		final StripesClassesScanner<ActionBean> scanner = new StripesClassesScanner<>();
		scanner.addIncludeFilter(new AssignableTypeFilter(ActionBean.class));
		final Collection<Class<? extends ActionBean>> actionbeans = scanner.findComponentClasses("");
		final String packages = scanner.toPackagesWithoutStripesClasses(actionbeans);
		Assert.state(!StringUtils.isEmpty(packages),
				"Didn't find classes implementing ActionBean, check your application build and/or your " +
						"stripes.action-resolver-packages property on application.properties");

		System.out.println("Detected ActionBeans on " + packages);

		return packages;
	}


	void defaultIfEmpty(final Map<String, String> params, final String key, final String value,
			final Supplier<String> defaultValue)
	{
		if (StringUtils.isEmpty(value))
		{

			putIfNotEmpty(params, key, defaultValue.get());
		}
		else
		{
			putIfNotEmpty(params, key, value);
		}
	}


	void putIfNotEmpty(final Map<String, String> params, final String key, final String value)
	{
		if (!StringUtils.isEmpty(key) && !StringUtils.isEmpty(value))
		{
			params.put(key, value);
		}
	}
}
