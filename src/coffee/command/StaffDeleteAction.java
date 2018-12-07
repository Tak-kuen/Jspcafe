package coffee.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import coffee.bean.MenuBean;
import coffee.bean.MngrDBBean;
import coffee.bean.StaffListBean;

public class StaffDeleteAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		String admin_id=request.getParameter("admin_id");
		MngrDBBean dbPro= MngrDBBean.getInstance();
		dbPro.deleteStfInfo(admin_id);
		ArrayList<StaffListBean> list = new ArrayList<>();
		list = dbPro.getstaffList();
		request.getSession().setAttribute("stafflists", list);
		return "mngr/staff/staffForm.jsp";
	}

}
