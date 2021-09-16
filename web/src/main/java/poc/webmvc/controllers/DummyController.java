package poc.webmvc.controllers;


import poc.beans.DummyService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/webmvc")
public class DummyController
{
	private final DummyService service;


	public DummyController(DummyService service)
	{
		this.service = service;
	}


	@GetMapping(value = "/dummy", produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, String> helloworld()
	{
		Map<String, String> map = new HashMap<>();
		map.put("hello", service.sayHello("world"));
		map.put("service.hashCode", String.valueOf(service.hashCode()));
		return map;
	}
}
