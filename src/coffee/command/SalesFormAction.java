package coffee.command;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import coffee.bean.MngrDBBean;

public class SalesFormAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		String year = new Timestamp(System.currentTimeMillis()).toString();
		year=(year.substring(0, 4));
		MngrDBBean dbPro=MngrDBBean.getInstance();
		JSONArray sales=dbPro.getSales(year);
		
		request.getSession().setAttribute("sales",sales);
		return "/mngr/sales/salesForm.jsp";
	}
	

}
