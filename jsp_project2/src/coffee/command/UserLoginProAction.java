package coffee.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import coffee.bean.CustomerBean;
import coffee.bean.MngrDBBean;

public class UserLoginProAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("name");
		String num=request.getParameter("num");
		
		MngrDBBean dbPro = MngrDBBean.getInstance();
		int check = dbPro.cusCheck(num,name);
		
		CustomerBean customer=dbPro.numCheck(num);
		request.getSession().setAttribute("customer", customer);
		request.setAttribute("check", new Integer(check));
		request.setAttribute("num", num);
		return "/user/logon/uLoginPro.jsp";
	}

}
