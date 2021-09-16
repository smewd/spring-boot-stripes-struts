package poc.struts;


import lombok.Setter;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import poc.beans.DummyService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class DummyAction extends DispatchAction
{
	@Setter
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
}
