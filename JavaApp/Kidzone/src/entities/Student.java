package entities;

public class Student {
	private String name;
	private String address;
	private String parentName;
	private String phone;
	private String standard;
	private String regDate;
	
	public Student(){}

	public Student(String name, String address, String parentName, String phone, String standard, String regDate) {
		super();
		this.name = name;
		this.address = address;
		this.parentName = parentName;
		this.phone = phone;
		this.standard = standard;
		this.regDate = regDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
	
}
