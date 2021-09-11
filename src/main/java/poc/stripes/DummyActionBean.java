package poc.stripes;


import poc.beans.DummyService;
import lombok.Getter;
import lombok.Setter;
import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;
import net.sourceforge.stripes.integration.spring.SpringBean;


@UrlBinding("/stripes/dummy.action")
public class DummyActionBean implements ActionBean
{
	@SpringBean("dummyService")
	private DummyService dummyService;

	@Getter
	@Setter
	private ActionBeanContext context;


	@DefaultHandler
	public Resolution defaultHandler()
	{
		return new ForwardResolution("/WEB-INF/jsp/dummy.jsp");
	}


	public String getHello()
	{
		return dummyService.sayHello("Stripes DummyActionBean");
	}
}
