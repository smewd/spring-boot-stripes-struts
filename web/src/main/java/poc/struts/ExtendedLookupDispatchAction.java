package poc.struts;


import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.LookupDispatchAction;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;


public abstract class ExtendedLookupDispatchAction extends LookupDispatchAction {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws ServletException {
		final String action = this.getClass().getName();

		try {
			// Identify the request parameter containing the method name
			String parameter = mapping.getParameter();
			if (parameter == null) {
				String message = messages.getMessage("dispatch.handler", mapping.getPath());
				throw new ServletException(message + " must be set in the request");
			}

			// Identify the string to lookup
			String name = request.getParameter(parameter);
			if (name == null || "empty".equals(name)) {
				return dispatchMethod(mapping, form, request, response, "empty");
			}

			// First, check if the name exists as a plain key in the map.
			String methodName = getKeyMethodMap().get(name);
			if (methodName == null) {
				throw new NoSuchMethodException("\nCould not find method for " + action + "\n"
						+ "\tmethodName=null: parameter=" + parameter + " value=" + name + "\n"
						+ "\tin map " + getKeyMethodMap() + "\n");
			}

			return dispatchMethod(mapping, form, request, response, methodName);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}


	protected abstract Map<String, String> getKeyMethodMap();
}
