package coffee.command;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import java.util.*;
import java.io.*;

import coffee.bean.MenuBean;
import coffee.bean.MngrDBBean;

public class ImageUploadAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		String realFolder = "";
		String saveFolder = "/images";
		String encType = "utf-8";
		String filename = null;
		String menuName ="";
		int maxSize = 5 * 1024 * 1024;

		ServletContext context = request.getServletContext();
		realFolder = context.getRealPath(saveFolder);
		try {
			MultipartRequest upload = null;

			// 파일 업로드를 수행하는 MultipartRequest 객체 생성
			upload = new MultipartRequest(request, realFolder, maxSize, encType, new DefaultFileRenamePolicy());

			Enumeration<?> params = upload.getParameterNames();
			while (params.hasMoreElements()) {
				String name = (String) params.nextElement();
				if(name.equals("nameText")) {
					String value = upload.getParameter(name);
					menuName = value;
				}
			}
			// input 타입이 파일이 아닌 파라미터들을 얻어냄
			Enumeration<?> files = upload.getFileNames();
			// input 타입이 파일인 파라미터들의 정보 얻어냄
			while (files.hasMoreElements()) {
				String name = (String) files.nextElement();
				filename = upload.getFilesystemName(name);
				String original = upload.getOriginalFileName(name);
				String type = upload.getContentType(name);
				File file = upload.getFile(name);
				if (file != null) {
				} // if(file!=null)
			} // while input type="file"
			System.out.println(menuName);
			MngrDBBean dbPro = MngrDBBean.getInstance();
			dbPro.updateMenuimg(filename, menuName);
			ArrayList<MenuBean> list = new ArrayList<>();
			list = dbPro.getMenuList();
			request.getSession().setAttribute("menus", list);
			// 보통 결과를 JSON으로 리턴
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/mngr/menu/menuForm.jsp";
	}
}
