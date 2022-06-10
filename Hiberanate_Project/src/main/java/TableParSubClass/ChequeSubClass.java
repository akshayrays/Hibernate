package TableParSubClass;

public class ChequeSubClass extends PaymentSubclass {

	private int chqNumber;
	private String bankName;

	public ChequeSubClass() {

	}

	public int getChqNumber() {
		return chqNumber;
	}

	public void setChqNumber(int chqNumber) {
		this.chqNumber = chqNumber;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

}
