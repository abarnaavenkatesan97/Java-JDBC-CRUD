package bankPackage;

public class Bank {
	private int bankid;
	private String bankname;
	private float rateofinterest;
	private int numberofbranches;

	public Bank(int bankid, String bankname, float rateofinterest, int numberofbranches) {
		this.bankid = bankid;
		this.bankname = bankname;
		this.rateofinterest = rateofinterest;
		this.numberofbranches = numberofbranches;
	}

	public int getBankid() {
		return bankid;
	}

	public String getBankname() {
		return bankname;
	}

	public float getRateofinterest() {
		return rateofinterest;
	}

	public int getNumberofbranches() {
		return numberofbranches;
	}

	public void displayBankInfo() {
		System.out.println("Bank id : " + bankid + ",Bankname : " + bankname + ",Rateofinterest : " + rateofinterest
				+ ",Numberofbranches : " + numberofbranches);
	}

}
