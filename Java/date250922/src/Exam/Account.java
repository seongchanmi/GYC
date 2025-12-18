package Exam;

public class Account {

	private int accountNumber;
	private String owner;
	private int balance;

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "계좌번호: [" + accountNumber + "], 예금주: [" + owner + "], 잔액: [" + balance + "]원";
	}

}
