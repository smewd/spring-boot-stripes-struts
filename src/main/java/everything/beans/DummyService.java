package everything.beans;


import org.springframework.stereotype.Service;


@Service
public class DummyService
{
	public String sayHello(String name)
	{
		return "Hello " + name;
	}
}
