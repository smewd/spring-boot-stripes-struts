package poc.init.config.stripes;


import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.function.Supplier;


public class ParamMap<U, V> extends HashMap<U, V>
{
	public void putIfNotEmpty(U key, V value)
	{
		if (!StringUtils.isEmpty(value))
		{
			put(key, value);
		}
	}


	public void defaultIfEmpty(U key, V value, Supplier<V> defaultValueSupplier)
	{
		if (StringUtils.isEmpty(value))
		{
			put(key, defaultValueSupplier.get());
		}
		else
		{
			put(key, value);
		}
	}
}
