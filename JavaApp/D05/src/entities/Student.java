package entities;

import java.util.Vector;

public class Student {
	private String st_id;
	private String lastname;
	private String firstname;
	private Boolean gender;
	private int phone;
	private String batchno;
	
	public Student(){
		
	}

	
	public Student(String st_id, String lastname, String firstname, Boolean gender, int phone, String batchno) {
		super();
		this.st_id = st_id;
		this.lastname = lastname;
		this.firstname = firstname;
		this.gender = gender;
		this.phone = phone;
		this.batchno = batchno;
	}
	
	public Vector toVector(){
		Vector v = new Vector<>();
		v.add(st_id);
		v.add(lastname);
		v.add(firstname);
		v.add(gender?"Male":"Female");
		v.add(phone);
		v.add(batchno);
		return v;
	}
	

	@Override
	public String toString() {
		return "Student [st_id=" + st_id + ", lastname=" + lastname + ", firstname=" + firstname + ", gender=" + gender
				+ ", phone=" + phone + ", batchno=" + batchno + "]";
	}
}
