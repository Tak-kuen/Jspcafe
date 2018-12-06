<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>
<%@ page import="coffee.bean.MngrDBBean" %>

<% request.setCharacterEncoding("utf-8"); %>
<%
	String realFolder ="";
	String saveFolder ="/images";
	String encType="utf-8";
	String result=null;
	String filename=null;
	int maxSize = 5*1024*1024;
	
	ServletContext context = getServletContext();
	realFolder = context.getRealPath(saveFolder);
	
	try{
		MultipartRequest upload =null;
		
		//파일 업로드를 수행하는 MultipartRequest 객체 생성
		upload = new MultipartRequest(request, realFolder, maxSize, encType, new DefaultFileRenamePolicy());		
						
		//input 타입이 파일인 파라미터들을 얻어냄
		Enumeration<?> files = upload.getFileNames();
		//input 타입이 파일인 파라미터들의 정보 얻어냄
		while(files.hasMoreElements()) {
			String name=(String)files.nextElement();
			filename = upload.getFilesystemName(name);
			String original = upload.getOriginalFileName(name);
			String type=upload.getContentType(name);
			File file = upload.getFile(name);
			if(file != null) {
			result+=filename;
			}//if(file!=null)
		}//while input type="file"
		MngrDBBean dbPro = MngrDBBean.getInstance();
		dbPro.insertMenuimg(filename);
		out.println(result);
		//보통 결과를 JSON으로 리턴
		
		
		
	}catch(Exception e) {
		e.printStackTrace();
	}
%>