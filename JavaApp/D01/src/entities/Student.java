package entities;

public class Student {
	String hoTen;
	String email;
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Student(String hoTen, String email){
		this.hoTen=hoTen;
		this.email=email;
	}
	@Override
	public String toString() {
		return "Student [hoTen=" + hoTen + ", email=" + email + "]";
	}
	
	
	
}
