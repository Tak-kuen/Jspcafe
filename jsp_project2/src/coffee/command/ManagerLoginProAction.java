package coffee.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import coffee.bean.MngrDBBean;

public class ManagerLoginProAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String id=request.getParameter("id");
		String passwd=request.getParameter("passwd");
		
		MngrDBBean dbPro = MngrDBBean.getInstance();
		int check = dbPro.userCheck(id,passwd);
		
		HttpSession session = request.getSession();
		session.setAttribute("menus", dbPro.getMenuList());
		session.setAttribute("customlists", dbPro.getCustomerList());
		session.setAttribute("stafflists", dbPro.getstaffList());
		request.setAttribute("check", new Integer(check));
		request.setAttribute("id", id);
		return "/mngr/logon/mLoginPro.jsp";
	}

}
