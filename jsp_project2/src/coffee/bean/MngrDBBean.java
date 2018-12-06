package coffee.bean;

import java.sql.*;
import java.util.ArrayList;
import org.json.*;

import javax.naming.*;
import javax.sql.DataSource;

public class MngrDBBean {
	//싱글톤 DBBean 생성
	private static MngrDBBean instance = new MngrDBBean();
	public static MngrDBBean getInstance()	{return instance;}
	private MngrDBBean() {}
	JSONObject jsonObject;
	JSONArray jsonArray = new JSONArray();
	
	//커넥션풀 가져오는 메소드
	private Connection getConnection() throws Exception {
		Context initCtx = new InitialContext();
		Context envCtx = (Context)initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource)envCtx.lookup("jdbc/test");
		return ds.getConnection();
	}
	
	public int userCheck(String id, String passwd) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int x=-1;
		
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement("select admin_pass,admin_class from admin where admin_id=?");
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				String dbpass=rs.getString("admin_pass");
				if(passwd.equals(dbpass)) {
					if(rs.getInt("admin_class")==1) {
						x=2;
					}else {
						x=1;
					}
				}else {
					x=0;
				}
			}else {
				x=-1;
			}//rs.next
		} catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(rs!=null) try {rs.close();} catch(SQLException ex) {}
			if(pstmt!=null) try {pstmt.close();} catch(SQLException ex) {}
			if(conn!=null) try {conn.close();} catch(SQLException ex) {}
		}
		return x;
	}//userCheck
	
	public CustomerBean numCheck(String num) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int x=-1;
		CustomerBean Csbean=null;
		
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement("select * from customer where cus_num=?");
			pstmt.setString(1, num);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				Csbean=new CustomerBean();
				Csbean.setCus_name(rs.getString("cus_name"));
				Csbean.setCus_mile(rs.getInt("cus_mile"));
			}else {
			}//rs.next
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(rs!=null) try {rs.close();} catch(SQLException ex) {}
			if(pstmt!=null) try {pstmt.close();} catch(SQLException ex) {}
			if(conn!=null) try {conn.close();} catch(SQLException ex) {}
		}
		return Csbean;
	}
	
	public int cusCheck(String num, String name) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int x=-1;
		
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement("select cus_num from customer where cus_name=?");
			pstmt.setString(1, name);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				String dbnum=rs.getString("cus_num");
				if(num.equals(dbnum)) {
					x=1;
				}else {
					x=0;
				}
			}else {
				x=-1;
			}//rs.next
		} catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(rs!=null) try {rs.close();} catch(SQLException ex) {}
			if(pstmt!=null) try {pstmt.close();} catch(SQLException ex) {}
			if(conn!=null) try {conn.close();} catch(SQLException ex) {}
		}
		return x;
	}
	
	public ArrayList<MenuBean> getMenuList() {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList <MenuBean> menu;
		MenuBean bean;
		menu=new ArrayList<>();
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement("select * from menu");
			rs=pstmt.executeQuery();
			while(rs.next()) {
				bean=new MenuBean();
				bean.setMenu_ctgr(rs.getInt("menu_ctgr"));
				bean.setMenu_code(rs.getString("menu_code"));
				bean.setMenu_name(rs.getString("menu_name"));
				bean.setMenu_price(rs.getInt("menu_price"));
				bean.setMenu_image(rs.getString("menu_image"));
				menu.add(bean);
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(rs!=null) try {rs.close();} catch(SQLException ex) {}
			if(pstmt!=null) try {pstmt.close();} catch(SQLException ex) {}
			if(conn!=null) try {conn.close();} catch(SQLException ex) {}
		}
		return menu;
	}
	
	public ArrayList<CustomerListBean> getCustomerList() {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList <CustomerListBean> customer =null;
		CustomerListBean cbean;
		customer=new ArrayList<>();
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement("select * from customer");
			rs=pstmt.executeQuery();
			while(rs.next()) {
				cbean=new CustomerListBean();
				cbean.setCus_num(rs.getString("cus_num"));
				cbean.setCus_name(rs.getString("cus_name"));
				cbean.setCus_regdate(rs.getTimestamp("cus_regdate"));
				cbean.setCus_mile(rs.getInt("cus_mile"));
				customer.add(cbean);
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(rs!=null) try {rs.close();} catch(SQLException ex) {}
			if(pstmt!=null) try {pstmt.close();} catch(SQLException ex) {}
			if(conn!=null) try {conn.close();} catch(SQLException ex) {}
		}
		return customer;
	}
	
	public ArrayList<StaffListBean> getstaffList() {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList <StaffListBean> staff =null;
		StaffListBean sbean;
		staff=new ArrayList<>();
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement("select * from admin");
			rs=pstmt.executeQuery();
			while(rs.next()) {
				sbean=new StaffListBean();
				sbean.setAdmin_id(rs.getString("admin_id"));
				sbean.setAdmin_pass(rs.getString("admin_pass"));
				sbean.setAdmin_regdate(rs.getTimestamp("admin_regdate"));
				sbean.setAdmin_class(rs.getInt("admin_class"));
				sbean.setAdmin_addr(rs.getString("admin_addr"));
				sbean.setAdmin_num(rs.getString("admin_num"));
				sbean.setAdmin_profile(rs.getString("admin_profile"));
				staff.add(sbean);
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(rs!=null) try {rs.close();} catch(SQLException ex) {}
			if(pstmt!=null) try {pstmt.close();} catch(SQLException ex) {}
			if(conn!=null) try {conn.close();} catch(SQLException ex) {}
		}
		return staff;
	}
	
	
	
	public void updateMenuimg(String filename, String menu_name) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement("update menu set menu_image=?  where menu_name=?");
			pstmt.setString(1, "/"+filename);
			pstmt.setString(2, menu_name);
			pstmt.executeUpdate();
		} catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(pstmt!=null) try {pstmt.close();} catch(SQLException ex) {}
			if(conn!=null) try {conn.close();} catch(SQLException ex) {}
		}
	}
	
	public void insertMenu() {
		
	}
}
