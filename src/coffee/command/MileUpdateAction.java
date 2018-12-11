package coffee.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import coffee.bean.MngrDBBean;

public class MileUpdateAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		JSONObject mileset = new JSONObject();
		String rmin_amt=(request.getParameter("min_amt"));
		String rpercent=(request.getParameter("percent"));
		String ruselimit=(request.getParameter("uselimit"));
		String rusemeasure=(request.getParameter("usemeasure"));
		mileset.put("min_amt", rmin_amt);
		mileset.put("percent", rpercent);
		mileset.put("uselimit", ruselimit);
		mileset.put("usemeasure", rusemeasure);
//		if(mileset.get("min_amt") instanceof String) {
//			System.out.println(mileset.get("min_amt")+"String");
//		}if(mileset.get("min_amt") instanceof Integer) {
//			System.out.println(mileset.get("min_amt")+"Integer");
//		}
//		
//		System.out.println(mileset.get("percent"));
//		System.out.println(mileset.get("uselimit"));
//		System.out.println(mileset.get("usemeasure"));
		
		MngrDBBean dbPro=MngrDBBean.getInstance();
//		dbPro.setMileSet(mileset);
		dbPro.setMileSet(rmin_amt,rpercent,ruselimit,rusemeasure);
		request.getSession().setAttribute("mileset", dbPro.getMileSet());
		
		
		
		return "/mngr/mileage/mileageForm.jsp";
	}

}
