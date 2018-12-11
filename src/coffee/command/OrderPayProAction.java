package coffee.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import coffee.bean.MngrDBBean;

public class OrderPayProAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		int order_money=Integer.parseInt(request.getParameter("order_money"));
		String admin_id=request.getParameter("admin_id");
		String cus_num=request.getParameter("cus_num");
		String mile=request.getParameter("cus_mile");
		MngrDBBean dbPro = MngrDBBean.getInstance();
		int cus_mile=0;
		if(mile==null||mile.equals("")||mile.equals("0")) {
			
		}else {
			cus_mile=Integer.parseInt(mile);
			dbPro.mileUpdate(cus_num,cus_mile);
		}
		System.out.println(cus_mile);
		dbPro.orderInsert(order_money, admin_id, cus_num);
		return "/mngr/managerMain.jsp";
	}

}
