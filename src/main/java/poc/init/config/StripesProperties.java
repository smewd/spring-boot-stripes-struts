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
	 * The FQN of a class that implements ActionBeanPropertyBinder.
	 */
	private String actionBeanPropertyBinder;

	/**
	 * The FQN of a class that implements ActionBeanContextFactory
	 */
	private String actionBeanContextFactory;

	/**
	 * The FQN of a class which extends ActionBeanContext
	 */
	private String actionBeanContext;

	/**
	 * The FQN of a class that implements ActionResolver
	 */
	private String actionResolver;

	/**
	 * A comma-separated list of package roots where your ActionBean classes are. Stripes auto-discovers your ActionBeans at runtime by scanning those
	 * packages and their subpackages. This saves you from having to enumerate all your ActionBeans somewhere and maintaining that when you add, change,
	 * or remove ActionBeans.
	 */
	private String actionResolverPackages;

	/**
	 * The fully qualified name of a class that implements Configuration
	 */
	private String configuration;

	/**
	 * Interceptors that are loaded by Stripes, regardless to Interceptor.Class param. Those are loaded before Interceptors' one, if any
	 */
	private String coreInterceptorClasses;

	/**
	 * Flag to enable, or not, Stripes configuration
	 */
	private String enable;

	/**
	 * The FQN of a class that implements ExceptionHandler
	 */
	private String exceptionHandler;

	/**
	 * A comma separated list of package roots where your ExceptionHandlers are. Stripes will also search the packages specified in Extension. Packages
	 * for ExceptionHandlers so this parameter usually is not necessary.
	 */
	private String delegatingExceptionHandlerPackages;

	/**
	 * A list of packages that will be searched for Stripes extensions. Examples of extensions include interceptors, formatters, type converters, exception
	 * handlers, object post-processors (release 1.6. and later) and custom implementations of ActionResolver, ActionBeanContext, ActionBeanContextFactory,
	 * FormatterFactory, LocalePicker, LocalizationBundleFactory, MultipartWrapperFactory, PopulationStrategy, TagErrorRendererFactory, TypeConverterFactory
	 * and ObjectFactory (release 1.6 and later). Most applications can simply set the Extension.Packages, ActionResolver.Packages and Stripes.EncryptionKey
	 * parameters and be done.
	 */
	private String extensionPackages;

	/**
	 * The FQN of a class that implements FormatterFactory
	 */
	private String formatterFactory;

	/**
	 * The comma-separated list of fully qualified class names of Interceptor classes to use. The list may contain additional whitespace. Entries higher
	 * up the list will be invoked before entries lower down.
	 */
	private String interceptors;

	/**
	 * The FQN of a class that implements LocalePicker
	 */
	private String localePicker;

	/**
	 * A comma separated list of locales that the system supports. Each locale can be one to three segments long (e.g. en or en-us or en-us-mac). Either
	 * hypens or underscores can be used to separate the segments. In addition each locale can optinally include a character encoding to use with that
	 * locale. The character encoding is specified by appending :encoding to the locale, e.g. en_US:UTF-8
	 */
	private String locales;

	/**
	 * The FQN of a class that implements LocalizationBundleFactory
	 */
	private String localizationBundleFactory;

	/**
	 * The name of a resource bundle. This may by any kind of resource bundle, but will typically be a property resource bundle, in which case the
	 * resource files should be available in the classpath.
	 */
	private String errorMessageBundle;

	/**
	 * The name of a resource bundle. This may by any kind of resource bundle, but will typically be a property resource bundle, in which case the
	 * resource files should be available in the classpath.
	 */
	private String fieldNameBundle;

	/**
	 * The FQN of a class that implements MultipartWrapperFactory
	 */
	private String multipartWrapperFactory;

	/**
	 * The fully qualified name of the class, implementing MultipartWrapper.
	 */
	private String multipartWrapper;

	/**
	 * The maximum HTTP Post size, in bytes, that will be accepted by the server. Note that this is not the maximum file size, but the combined size of
	 * all files in a single upload plus any other form fields and headers. In practical terms, this should be slightly larger (say 20-50k) than the maximum
	 * file size you want to handle, in order to allow for a reasonable amount of other data to come in the same request. The number is assumed to be in
	 * bytes unless a k/kb/m/mb/g/gb suffix is applied.
	 */
	private String fileUploadMaximumPostSize;

	/**
	 * The FQN of a class that implements PopulationStrategy
	 */
	private String populationStrategy;

	/**
	 * The FQN of a class that implements TagErrorRendererFactory
	 */
	private String tagErrorRendererFactory;

	/**
	 * The FQN of a class that implements TypeConverterFactory
	 */
	private String typeConverterFactory;

	/**
	 * A boolean flag that turns debug mode off or on. This should only be set to true during development. Currently, debug mode only turns off encryption,
	 * allowing a developer to read values that would otherwise be encrypted before being written to the client.
	 * WARNING: Do not turn on debug mode in a production server. When encryption is disabled, you risk exposing resources that are normally protected, such
	 * as those under /WEB-INF.
	 */
	private String debugMode;

	/**
	 * A (preferably very long, very random) string that is used as the encryption key when Stripes encrypts values before sending them to the client. If
	 * no encryption key is specified, then a random one is generated each time the application is initialized. When a random key is used, encrypted values
	 * do not survive across application reloads.
	 */
	private String encryptionKey;

	/**
	 * The type of HTML tags Stripes should generate. Options are html or xhtml
	 */
	private String htmlMode;

	/**
	 * The comma-separated list of fully qualified class names of VFS implementations to use in addition to the built-in implementations shipped with
	 * Stripes. The list may contain additional whitespace. The implementations are tried in the order they are specified and before any built-ins.
	 */
	private String vfsClasses;

	/**
	 * placeholder for custom configuration
	 */
	private Map<String, String> customConf = new HashMap<String, String>();
}
