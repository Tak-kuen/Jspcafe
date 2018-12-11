package coffee.bean;

import java.sql.*;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

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
	
	public JSONArray getSales(String year) {
		JSONArray sales=new JSONArray();
		JSONObject bean=null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=getConnection();
			pstmt = conn.prepareStatement("select substring(order_date, 1, 7) as month, sum(order_money) as totalSales from orderlist where order_date like ? group by month");
			pstmt.setString(1, year+"%");
			rs=pstmt.executeQuery();
			while(rs.next()) {
				bean=new JSONObject();
				bean.put("month",rs.getString("month"));
				bean.put("totalSales", Integer.parseInt(rs.getString("totalSales")));
				sales.add(bean);
			}
			int a=sales.size();
			System.out.println(a);
		} catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(rs!=null) try {rs.close();} catch(SQLException ex) {}
			if(pstmt!=null) try {pstmt.close();} catch(SQLException ex) {}
			if(conn!=null) try {conn.close();} catch(SQLException ex) {}
	      }
		return sales;
	}
	
	
	public int getMile(String cus_num) {
		int mile=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
	      
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement("select cus_mile from customer where cus_num=?");
			pstmt.setString(1, cus_num);
			rs=pstmt.executeQuery();
			if(rs.next()) {	
				mile=rs.getInt("cus_mile");
			} else{//rs.next
				mile=0;
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(rs!=null) try {rs.close();} catch(SQLException ex) {}
			if(pstmt!=null) try {pstmt.close();} catch(SQLException ex) {}
			if(conn!=null) try {conn.close();} catch(SQLException ex) {}
	      }
		
		
		return mile;
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
	         pstmt=conn.prepareStatement("select * from customer where cus_name=?");
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
	
//	public JSONArray getMenuList() {
//		Connection conn=null;
//		PreparedStatement pstmt=null;
//		ResultSet rs=null;
//		JSONArray menu;
//		JSONObject bean;
//		menu=new JSONArray();
//		try {
//			conn=getConnection();
//			pstmt=conn.prepareStatement("select * from menu");
//			rs=pstmt.executeQuery();
//			while(rs.next()) {
//				bean=new JSONObject();
//				bean.put("menu_ctgr",rs.getInt("menu_ctgr"));
//				bean.put("menu_name",rs.getString("menu_name"));
//				bean.put("menu_price",rs.getInt("menu_price"));
//				bean.put("menu_image",rs.getString("menu_image"));
//				menu.put(bean);
//			}
//		} catch(Exception ex) {
//			ex.printStackTrace();
//		}finally {
//			if(rs!=null) try {rs.close();} catch(SQLException ex) {}
//			if(pstmt!=null) try {pstmt.close();} catch(SQLException ex) {}
//			if(conn!=null) try {conn.close();} catch(SQLException ex) {}
//		}
//		return menu;
//	}
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
	
	public JSONArray getCustomerList() {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		JSONArray customer =new JSONArray();
		JSONObject bean;
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement("select * from customer");
			rs=pstmt.executeQuery();
			while(rs.next()) {
				bean=new JSONObject();
				bean.put("cus_num",rs.getString("cus_num"));
				bean.put("cus_name",rs.getString("cus_name"));
				bean.put("cus_mile",rs.getInt("cus_mile"));
				customer.add(bean);
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
//	public ArrayList<CustomerListBean> getCustomerList() {
//		Connection conn=null;
//		PreparedStatement pstmt=null;
//		ResultSet rs=null;
//		ArrayList <CustomerListBean> customer =null;
//		CustomerListBean cbean;
//		customer=new ArrayList<>();
//		try {
//			conn=getConnection();
//			pstmt=conn.prepareStatement("select * from customer");
//			rs=pstmt.executeQuery();
//			while(rs.next()) {
//				cbean=new CustomerListBean();
//				cbean.setCus_num(rs.getString("cus_num"));
//				cbean.setCus_name(rs.getString("cus_name"));
//				cbean.setCus_regdate(rs.getTimestamp("cus_regdate"));
//				cbean.setCus_mile(rs.getInt("cus_mile"));
//				customer.add(cbean);
//			}
//		} catch(Exception ex) {
//			ex.printStackTrace();
//		}finally {
//			if(rs!=null) try {rs.close();} catch(SQLException ex) {}
//			if(pstmt!=null) try {pstmt.close();} catch(SQLException ex) {}
//			if(conn!=null) try {conn.close();} catch(SQLException ex) {}
//		}
//		return customer;
//	}
	
	public JSONArray getstaffList() {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		JSONArray staff =new JSONArray();
		JSONObject bean;
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement("select * from admin");
			rs=pstmt.executeQuery();
			while(rs.next()) {
				bean=new JSONObject();
				bean.put("admin_id",rs.getString("admin_id"));
				bean.put("admin_pass",rs.getString("admin_pass"));
				bean.put("admin_name",rs.getString("admin_name"));
				bean.put("admin_regdate",rs.getTimestamp("admin_regdate"));
				bean.put("admin_class",rs.getInt("admin_class"));
				bean.put("admin_addr",rs.getString("admin_addr"));
				bean.put("admin_num",rs.getString("admin_num"));
				bean.put("admin_profile",rs.getString("admin_profile"));
				staff.add(bean);
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
//	public ArrayList<StaffListBean> getstaffList() {
//		Connection conn=null;
//		PreparedStatement pstmt=null;
//		ResultSet rs=null;
//		ArrayList <StaffListBean> staff =null;
//		StaffListBean sbean;
//		staff=new ArrayList<>();
//		try {
//			conn=getConnection();
//			pstmt=conn.prepareStatement("select * from admin");
//			rs=pstmt.executeQuery();
//			while(rs.next()) {
//				sbean=new StaffListBean();
//				sbean.setAdmin_id(rs.getString("admin_id"));
//				sbean.setAdmin_pass(rs.getString("admin_pass"));
//				sbean.setAdmin_name(rs.getString("admin_name"));
//				sbean.setAdmin_regdate(rs.getTimestamp("admin_regdate"));
//				sbean.setAdmin_class(rs.getInt("admin_class"));
//				sbean.setAdmin_addr(rs.getString("admin_addr"));
//				sbean.setAdmin_num(rs.getString("admin_num"));
//				sbean.setAdmin_profile(rs.getString("admin_profile"));
//				staff.add(sbean);
//			}
//		} catch(Exception ex) {
//			ex.printStackTrace();
//		}finally {
//			if(rs!=null) try {rs.close();} catch(SQLException ex) {}
//			if(pstmt!=null) try {pstmt.close();} catch(SQLException ex) {}
//			if(conn!=null) try {conn.close();} catch(SQLException ex) {}
//		}
//		return staff;
//	}
	
	//마일리지 설정정보 가져오긴
	public JSONObject getMileSet() {
		JSONObject mileset=null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement("select * from milelimit");
			rs=pstmt.executeQuery();
			if(rs.next()) {
				mileset=new JSONObject();
				mileset.put("uselimit", rs.getInt("uselimit"));
				mileset.put("usemeasure", rs.getInt("usemeasure"));
				mileset.put("percent", rs.getInt("percent"));
				mileset.put("min_amt", rs.getInt("min_amt"));
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(pstmt!=null) try {pstmt.close();} catch(SQLException ex) {}
			if(conn!=null) try {conn.close();} catch(SQLException ex) {}
		}
		return mileset;
	}
	
	public void setMileSet(JSONObject mileset) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		if(mileset.get("uselimit") instanceof String) {
			System.out.println(mileset.get("uselimit"));
		}
		String uselimit=(String) mileset.get("uselimit");
		String usemeasure=(String) mileset.get("usemeasure");
		String percent=(String) mileset.get("percent");
		String min_amt=(String) mileset.get("min_amt");
		System.out.println(Integer.parseInt(uselimit));
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement("update milelimit set uselimit=?, usemeasure=?,percent=?,min_amt=?");
			pstmt.setInt(1, Integer.parseInt(uselimit));
			pstmt.setInt(2, Integer.parseInt(usemeasure));
			pstmt.setInt(3, Integer.parseInt(percent));
			pstmt.setInt(4, Integer.parseInt(min_amt));
		} catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(pstmt!=null) try {pstmt.close();} catch(SQLException ex) {}
			if(conn!=null) try {conn.close();} catch(SQLException ex) {}
		}
	}
public void setMileSet(String rmin_amt, String rpercent, String ruselimit, String rusemeasure) {
	Connection conn=null;
	PreparedStatement pstmt=null;
	System.out.println(rmin_amt+rpercent+rusemeasure+ruselimit);
	try {
		conn=getConnection();
		pstmt=conn.prepareStatement("update milelimit set uselimit=?, usemeasure=?,percent=?,min_amt=?");
		pstmt.setInt(1, Integer.parseInt(ruselimit));
		pstmt.setInt(2, Integer.parseInt(rusemeasure));
		pstmt.setInt(3, Integer.parseInt(rpercent));
		pstmt.setInt(4, Integer.parseInt(rmin_amt));
		pstmt.executeUpdate();
	} catch(Exception ex) {
		ex.printStackTrace();
	}finally {
		if(pstmt!=null) try {pstmt.close();} catch(SQLException ex) {}
		if(conn!=null) try {conn.close();} catch(SQLException ex) {}
	}
}
public JSONArray getOrderList(String cus_num) {
	JSONArray orderlist=new JSONArray();
	JSONObject bean=null;
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	try {
		conn=getConnection();
		pstmt=conn.prepareStatement("select * from orderlist where cus_num=?");
		pstmt.setString(1, cus_num);
		rs=pstmt.executeQuery();
		while(rs.next()) {
			bean=new JSONObject();
			bean.put("order_money", rs.getInt("order_money"));
			bean.put("cus_num", rs.getString("cus_num"));
			bean.put("admin_id", rs.getString("admin_id"));
			bean.put("order_date", rs.getTimestamp("order_date"));
			orderlist.add(bean);
		}
	} catch(Exception ex) {
		ex.printStackTrace();
	}finally {
		if(pstmt!=null) try {pstmt.close();} catch(SQLException ex) {}
		if(conn!=null) try {conn.close();} catch(SQLException ex) {}
		if(rs!=null) try {rs.close();} catch(SQLException ex) {}
	}
	return orderlist;
}
	
	////메뉴관리 메소드
	public void updateMenuImg(MenuBean bean) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement("update menu set menu_name=?,menu_price=?,menu_image=?,menu_ctgr=?  where menu_name=?");
			pstmt.setString(1, bean.getMenu_name());
			pstmt.setInt(2, bean.getMenu_price());
			pstmt.setString(3, "/"+bean.getMenu_image());
			pstmt.setInt(4, bean.getMenu_ctgr());
			pstmt.setString(5, bean.getMenu_name());
			pstmt.executeUpdate();
		} catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(pstmt!=null) try {pstmt.close();} catch(SQLException ex) {}
			if(conn!=null) try {conn.close();} catch(SQLException ex) {}
		}
	}
	
	public void insertMenu(MenuBean bean) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement("insert into menu(menu_name,menu_price,menu_image,menu_ctgr) values(?,?,?,?)");
			pstmt.setString(1, bean.getMenu_name());
			pstmt.setInt(2, bean.getMenu_price());
			pstmt.setString(3, "/"+bean.getMenu_image());
			pstmt.setInt(4, bean.getMenu_ctgr());
			pstmt.executeUpdate();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(pstmt!=null) try {pstmt.close();} catch(SQLException ex) {}
			if(conn!=null) try {conn.close();} catch(SQLException ex) {}
		}
		
	}
	public void deleteMenu(String menu_name) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement("delete from menu where menu_name=?");
			pstmt.setString(1,menu_name);
			pstmt.executeUpdate();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(pstmt!=null) try {pstmt.close();} catch(SQLException ex) {}
			if(conn!=null) try {conn.close();} catch(SQLException ex) {}
		}
	}
	
	
	////직원정보 관리 메소드
	public void updateStfInfo(StaffListBean bean) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement("update admin set admin_id=?,"
					+ "admin_pass=?,admin_name=?,admin_addr=?,admin_profile=?,"
					+ "admin_class=2  where admin_id=?");
			pstmt.setString(1, bean.getAdmin_id());
			pstmt.setString(2, bean.getAdmin_pass());
			pstmt.setString(3,bean.getAdmin_name());
			pstmt.setString(4, bean.getAdmin_addr());
			pstmt.setString(5,"/" + bean.getAdmin_profile());
			pstmt.setString(6, bean.getAdmin_id());
			pstmt.executeUpdate();
		} catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(pstmt!=null) try {pstmt.close();} catch(SQLException ex) {}
			if(conn!=null) try {conn.close();} catch(SQLException ex) {}
		}
	}
	public void insertStfInfo(StaffListBean bean) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		bean.setAdmin_regdate(new Timestamp(System.currentTimeMillis()));
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement("insert into admin values(?,?,?,?,?,?,?,?)");
			pstmt.setString(1, bean.getAdmin_id());
			pstmt.setString(2, bean.getAdmin_pass());
			pstmt.setString(3,bean.getAdmin_name());
			pstmt.setTimestamp(4,bean.getAdmin_regdate());
			pstmt.setInt(5, 2);
			pstmt.setString(6, bean.getAdmin_addr());
			pstmt.setString(7, bean.getAdmin_num());
			pstmt.setString(8, "/" + bean.getAdmin_profile());
			pstmt.executeUpdate();
		} catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(pstmt!=null) try {pstmt.close();} catch(SQLException ex) {}
			if(conn!=null) try {conn.close();} catch(SQLException ex) {}
		}
	}
	public void deleteStfInfo(String admin_id) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement("delete from admin where admin_id=?");
			pstmt.setString(1, admin_id);
			pstmt.executeUpdate();
		} catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(pstmt!=null) try {pstmt.close();} catch(SQLException ex) {}
			if(conn!=null) try {conn.close();} catch(SQLException ex) {}
		}
	}
	
	
	////고객정보 관리 메소드
	public void insertCusInfo(CustomerListBean bean) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		bean.setCus_regdate(new Timestamp(System.currentTimeMillis()));
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement("insert into customer values(?,?,?,?)");
			pstmt.setString(1,bean.getCus_num());
			pstmt.setString(2,bean.getCus_name());
			pstmt.setTimestamp(3,bean.getCus_regdate());
			pstmt.setInt(4, 0);
			pstmt.executeUpdate();
		} catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(pstmt!=null) try {pstmt.close();} catch(SQLException ex) {}
			if(conn!=null) try {conn.close();} catch(SQLException ex) {}
		}
	}
	
	public void updateCusInfo(CustomerListBean bean) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement("update customer set cus_name=?,cus_mile=? where cus_num=?");
			pstmt.setString(1,bean.getCus_name());
			pstmt.setInt(2, bean.getCus_mile());
			pstmt.setString(3,bean.getCus_num());
			pstmt.executeUpdate();
		} catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(pstmt!=null) try {pstmt.close();} catch(SQLException ex) {}
			if(conn!=null) try {conn.close();} catch(SQLException ex) {}
		}
	}
	
	public void deleteCusInfo(CustomerListBean bean) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement("delete from customer where cus_num=?");
			pstmt.setString(1,bean.getCus_num());
			pstmt.executeUpdate();
		} catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(pstmt!=null) try {pstmt.close();} catch(SQLException ex) {}
			if(conn!=null) try {conn.close();} catch(SQLException ex) {}
		}
	}
	public void orderInsert(int order_money, String admin_id, String cus_num) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Timestamp a=new Timestamp(System.currentTimeMillis());
		if(cus_num.equals("")) {
			cus_num=null;
		}
		int count=0;
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement("select order_num from orderlist order by order_num desc");
			rs=pstmt.executeQuery();
			if(rs.next()) {
				count=rs.getInt("order_num");
				System.out.println(count);
			}
			System.out.println(admin_id);
			System.out.println(cus_num);
			pstmt=conn.prepareStatement("insert into orderlist values(?,?,?,?,?)");
			pstmt.setInt(1,++count);
			pstmt.setInt(2,order_money);
			pstmt.setString(3, admin_id);
			pstmt.setString(4, cus_num);
			pstmt.setTimestamp(5,a);
			pstmt.executeUpdate();
		} catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(pstmt!=null) try {pstmt.close();} catch(SQLException ex) {}
			if(conn!=null) try {conn.close();} catch(SQLException ex) {}
		}
	}
	public void mileUpdate(String cus_num, int cus_mile) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement("update customer set cus_mile=? where cus_num=?");
			pstmt.setInt(1, cus_mile);
			pstmt.setString(2,cus_num);
			pstmt.executeUpdate();
		} catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(pstmt!=null) try {pstmt.close();} catch(SQLException ex) {}
			if(conn!=null) try {conn.close();} catch(SQLException ex) {}
		}
	}
	
	
	
	
	
}
