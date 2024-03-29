package poc.struts.servlet;


import org.apache.struts.action.ActionServlet;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;


@WebServlet(
		urlPatterns = "*.do",
		loadOnStartup = 1,
		asyncSupported = true,
		initParams = {
				@WebInitParam(name = "config", value = "/WEB-INF/struts-config.xml")
		}
)
public class BootActionServlet extends ActionServlet
{
}
