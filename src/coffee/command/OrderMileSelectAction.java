package coffee.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import coffee.bean.MngrDBBean;

public class OrderMileSelectAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String cus_num=request.getParameter("cus_num");
		String listHtml=request.getParameter("orderlist");
		MngrDBBean dbPro = MngrDBBean.getInstance();
		int mileage=dbPro.getMile(cus_num);
		request.getSession().setAttribute("cus_num",cus_num);
		request.getSession().setAttribute("cus_mile",mileage);
		request.getSession().setAttribute("listHtml", listHtml);
		return "/mngr/managerMain.jsp";
	}
}
