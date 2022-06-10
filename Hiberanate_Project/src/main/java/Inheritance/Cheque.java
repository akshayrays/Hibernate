package Inheritance;

public class Cheque extends Payment {

	private String chqNumber;
	private String bankNunmber;

	public String getChqNumber() {
		return chqNumber;
	}

	public void setChqNumber(String chqNumber) {
		this.chqNumber = chqNumber;
	}

	public String getBankNunmber() {
		return bankNunmber;
	}

	public void setBankNunmber(String bankNunmber) {
		this.bankNunmber = bankNunmber;
	}

}
