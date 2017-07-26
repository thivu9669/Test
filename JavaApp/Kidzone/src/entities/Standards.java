package entities;

public class Standards {
	private String standard;
	private int fee;
	
	public Standards(){}

	public Standards(String standard, int fee) {
		super();
		this.standard = standard;
		this.fee = fee;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}
	
}
