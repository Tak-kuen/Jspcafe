package coffee.bean;

import java.sql.Timestamp;

public class StaffListBean {
	private String admin_id;
	private String admin_pass;
	private String admin_name;
	private Timestamp admin_regdate;
	private int admin_class;
	private String admin_addr;
	private String admin_num;
	private String admin_profile;

	public String getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}

	public String getAdmin_pass() {
		return admin_pass;
	}

	public void setAdmin_pass(String admin_pass) {
		this.admin_pass = admin_pass;
	}

	public String getAdmin_name() {
		return admin_name;
	}

	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}

	public Timestamp getAdmin_regdate() {
		return admin_regdate;
	}

	public void setAdmin_regdate(Timestamp admin_regdate) {
		this.admin_regdate = admin_regdate;
	}

	public int getAdmin_class() {
		return admin_class;
	}

	public void setAdmin_class(int admin_class) {
		this.admin_class = admin_class;
	}

	public String getAdmin_addr() {
		return admin_addr;
	}

	public void setAdmin_addr(String admin_addr) {
		this.admin_addr = admin_addr;
	}

	public String getAdmin_num() {
		return admin_num;
	}

	public void setAdmin_num(String admin_num) {
		this.admin_num = admin_num;
	}

	public String getAdmin_profile() {
		return admin_profile;
	}

	public void setAdmin_profile(String admin_profile) {
		this.admin_profile = admin_profile;
	}

}