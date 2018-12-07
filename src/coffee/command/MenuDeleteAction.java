package coffee.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import coffee.bean.MenuBean;
import coffee.bean.MngrDBBean;

public class MenuDeleteAction implements CommandAction {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		String menu_name=request.getParameter("menu_name");
		MngrDBBean dbPro = MngrDBBean.getInstance();
		dbPro.deleteMenu(menu_name);
		ArrayList<MenuBean> list = new ArrayList<>();
		list = dbPro.getMenuList();
		request.getSession().setAttribute("menus", list);
		
		return "/mngr/menu/menuForm.jsp";
		
		
		
	}

}
