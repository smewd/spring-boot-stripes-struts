package poc.struts;


import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import poc.beans.DummyService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.TreeMap;


@Component("/dummy")
public class DummyAction extends ExtendedLookupDispatchAction {

	@Autowired
	private DummyService dummyService;


	@Override
	protected Map<String, String> getKeyMethodMap() {
		Map<String, String> map = new TreeMap<>();
		map.put("button_next", "next");
		return map;
	}


	public ActionForward empty(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws ServletException {
		DummyForm f = (DummyForm)form;
		f.setValue(dummyService.sayHello("Struts: "
				+ LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)));
		return mapping.findForward("dummy");
	}


	public ActionForward next(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws ServletException {
		DummyForm f = (DummyForm)form;
		f.setValue(dummyService.sayHello("Next: "
				+ LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)));
		return mapping.findForward("next");
	}
}
