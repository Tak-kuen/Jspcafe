package coffee.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MileFormAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String set = request.getParameter("set");
		String set2 = request.getParameter("set2");
		String set3 = request.getParameter("set3");
		String set4 = request.getParameter("set4");
		if(set != null)
		request.getSession().setAttribute("mileage", set);
		if(set2 != null)
		request.getSession().setAttribute("mileage2", set2);
		if(set3 != null)
		request.getSession().setAttribute("mileage3", set3);
		if(set4 != null)
		request.getSession().setAttribute("mileage4", set4);
		return "/mngr/mileage/mileageForm.jsp";
	}

}
