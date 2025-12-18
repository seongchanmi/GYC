package Exam;

public class AccountMain {

	public static void main(String[] args) {

		Account account1 = new Account();
		account1.setAccountNumber(123456789);
		account1.setOwner("성찬미");
		account1.setBalance(10000);

		System.out.println(account1.toString());
	}

}
