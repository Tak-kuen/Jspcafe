package coffee.bean;

public class MenuBean {
	private String menu_code;
	private String menu_name;
	private int menu_price;
	private String menu_image;
	private int menu_ctgr;
	
	public int getMenu_ctgr() {return menu_ctgr;}
	public void setMenu_ctgr(int menu_ctgr) {this.menu_ctgr = menu_ctgr;}
	
	public String getMenu_code() {return menu_code;}
	public void setMenu_code(String menu_code) {this.menu_code = menu_code;}
	
	public String getMenu_name() {return menu_name;}
	public void setMenu_name(String menu_name) {this.menu_name = menu_name;}
	
	public int getMenu_price() {return menu_price;}
	public void setMenu_price(int menu_price) {this.menu_price = menu_price;}
		
	public String getMenu_image() {return menu_image;}
	public void setMenu_image(String menu_image) {this.menu_image = menu_image;}
}
