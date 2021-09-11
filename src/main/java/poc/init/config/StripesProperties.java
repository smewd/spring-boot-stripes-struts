package poc.init.config;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.Map;


@ConfigurationProperties(prefix = StripesProperties.STRIPES_PREFIX)
@Getter
@Setter
public class StripesProperties
{

	public static final String STRIPES_PREFIX = "stripes";

	/**
	 * A comma-separated list of package roots where your ActionBean classes are. Stripes auto-discovers your ActionBeans at runtime by scanning those
	 * packages and their subpackages. This saves you from having to enumerate all your ActionBeans somewhere and maintaining that when you add, change,
	 * or remove ActionBeans.
	 */
	private String actionResolverPackages;

	/**
	 * A list of packages that will be searched for Stripes extensions. Examples of extensions include interceptors, formatters, type converters, exception
	 * handlers, object post-processors (release 1.6. and later) and custom implementations of ActionResolver, ActionBeanContext, ActionBeanContextFactory,
	 * FormatterFactory, LocalePicker, LocalizationBundleFactory, MultipartWrapperFactory, PopulationStrategy, TagErrorRendererFactory, TypeConverterFactory
	 * and ObjectFactory (release 1.6 and later). Most applications can simply set the Extension.Packages, ActionResolver.Packages and Stripes.EncryptionKey
	 * parameters and be done.
	 */
	private String extensionPackages;

	/**
	 * The comma-separated list of fully qualified class names of Interceptor classes to use. The list may contain additional whitespace. Entries higher
	 * up the list will be invoked before entries lower down.
	 */
	private String interceptors;

	/**
	 * A comma separated list of locales that the system supports. Each locale can be one to three segments long (e.g. en or en-us or en-us-mac). Either
	 * hypens or underscores can be used to separate the segments. In addition each locale can optinally include a character encoding to use with that
	 * locale. The character encoding is specified by appending :encoding to the locale, e.g. en_US:UTF-8
	 */
	private String locales;

	/**
	 * A boolean flag that turns debug mode off or on. This should only be set to true during development. Currently, debug mode only turns off encryption,
	 * allowing a developer to read values that would otherwise be encrypted before being written to the client.
	 * WARNING: Do not turn on debug mode in a production server. When encryption is disabled, you risk exposing resources that are normally protected, such
	 * as those under /WEB-INF.
	 */
	private String debugMode;

	/**
	 * The comma-separated list of fully qualified class names of VFS implementations to use in addition to the built-in implementations shipped with
	 * Stripes. The list may contain additional whitespace. The implementations are tried in the order they are specified and before any built-ins.
	 */
	private String vfsClasses;
}
