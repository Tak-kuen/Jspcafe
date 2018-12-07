package coffee.command;

import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import coffee.bean.MngrDBBean;
import coffee.bean.StaffListBean;

public class StaffInsertAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		String realFolder = "";
		String saveFolder = "/images";
		String encType = "utf-8";
		String filename = null;
		int maxSize = 5 * 1024 * 1024;

		ServletContext context = request.getServletContext();
		realFolder = context.getRealPath(saveFolder);
		try {
			MultipartRequest upload = null;

			// 파일 업로드를 수행하는 MultipartRequest 객체 생성
			upload = new MultipartRequest(request, realFolder, maxSize, encType, new DefaultFileRenamePolicy());

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
			StaffListBean bean=new StaffListBean();
			bean.setAdmin_pass(upload.getParameter("admin_pass"));
			bean.setAdmin_name(upload.getParameter("admin_name"));
			bean.setAdmin_addr(upload.getParameter("admin_addr"));
			bean.setAdmin_id(upload.getParameter("admin_id"));
			bean.setAdmin_profile(filename);
			MngrDBBean dbPro = MngrDBBean.getInstance();
			dbPro.updateStfInfo(bean);
			ArrayList<StaffListBean> list = new ArrayList<>();
			list = dbPro.getstaffList();
			request.getSession().setAttribute("stafflists", list);
			// 보통 결과를 JSON으로 리턴
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "mngr/staff/staffForm.jsp";
	}

}
