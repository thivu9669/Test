package entities;

public class Batch {
	private String batchno;
	private String description;
	private int fee;
	
	public Batch(){}

	public Batch(String batchno, String description, int fee) {
		super();
		this.batchno = batchno;
		this.description = description;
		this.fee = fee;
	}

	public String getBatchno() {
		return batchno;
	}

	public void setBatchno(String batchno) {
		this.batchno = batchno;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

}
