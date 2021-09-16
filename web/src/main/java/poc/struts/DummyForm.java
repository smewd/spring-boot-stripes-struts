package poc.struts;


import lombok.Getter;
import lombok.Setter;
import org.apache.struts.action.ActionForm;


@Getter
@Setter
public class DummyForm extends ActionForm
{
	private String value;
}
