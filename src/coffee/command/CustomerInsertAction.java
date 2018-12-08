package coffee.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

import coffee.bean.CustomerListBean;
import coffee.bean.MngrDBBean;

public class CustomerInsertAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		CustomerListBean bean=new CustomerListBean();
		System.out.println(request.getParameter("cus_mile"));
		bean.setCus_num(request.getParameter("cus_num"));
		bean.setCus_name(request.getParameter("cus_name"));
		bean.setCus_mile(Integer.parseInt(request.getParameter("cus_mile")));
		MngrDBBean dbPro = MngrDBBean.getInstance();
		dbPro.insertCusInfo(bean);
//		ArrayList<CustomerListBean> list=new ArrayList<>();
		JSONArray list=new JSONArray();
		list=dbPro.getCustomerList();
		request.getSession().setAttribute("customlists", list);
		
		return "mngr/customer/customerForm.jsp";
	}

}
