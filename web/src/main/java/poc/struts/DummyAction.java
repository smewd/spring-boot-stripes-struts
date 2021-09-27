package poc.struts;


import lombok.Setter;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionServlet;
import org.apache.struts.actions.DispatchAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import poc.beans.DummyService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Component("/dummy")
public class DummyAction extends DispatchAction
{
	@Autowired
	private DummyService dummyService;


	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response)
	{
		request.getSession().invalidate();
		DummyForm f = (DummyForm)form;
		f.setValue(dummyService.sayHello("Struts: " + LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)));

		return mapping.findForward("dummy");
	}

	@Override
	public void setServlet(ActionServlet servlet)
	{
		super.setServlet(servlet);
		System.out.println("\n\n\n\nDummyAction.setServlet\n\n\n\n");
	}
}
