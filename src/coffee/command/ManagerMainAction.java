package coffee.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ManagerMainAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.getSession().setAttribute("type",new Integer(0));
		return "/mngr/managerMain.jsp";
	}
	

}
