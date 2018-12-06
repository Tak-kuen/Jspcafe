package coffee.bean;

import java.sql.Timestamp;

public class CustomerBean {
	private String cus_num;
	private String cus_name;
	private Timestamp cus_regdate;
	private int cus_mile;
	public String getCus_num() {
		return cus_num;
	}
	public void setCus_num(String cus_num) {
		this.cus_num = cus_num;
	}
	public String getCus_name() {
		return cus_name;
	}
	public void setCus_name(String cus_name) {
		this.cus_name = cus_name;
	}
	public Timestamp getCus_regdate() {
		return cus_regdate;
	}
	public void setCus_regdate(Timestamp cus_regdate) {
		this.cus_regdate = cus_regdate;
	}
	public int getCus_mile() {
		return cus_mile;
	}
	public void setCus_mile(int cus_mile) {
		this.cus_mile = cus_mile;
	}
}
