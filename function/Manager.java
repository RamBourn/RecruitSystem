package function;

public class Manager {
	private String name;
	private String phone;
	private String connection;
	public Manager(String name,String phone,
			String connection) {
		setName(name);
		setPhone(phone);
		setConnection(connection);
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setPhone(String phone) {
		this.phone=phone;
	}
	public void setConnection(String connection) {
		this.connection=connection;
	}
	public String getName() {
		return name;
	}
	public String getPhone() {
		return phone;
	}
	public String getConnection() {
		return connection;
	}
	public String getDetail() {
		String detail="\n–’√˚:"+getName()+"\nµÁª∞£∫"+getPhone()+"\n” œ‰£∫";
		return detail;
	}

}
