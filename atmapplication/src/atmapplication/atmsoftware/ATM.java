package atmapplication.atmsoftware;

public class ATM {
	public Account authenticate(Account[] accounts, int accountCount, String accNum,String pin) {
		for(int i=0;i<accountCount;i++) {
			if(accounts[i]!=null&&accounts[i].getAccountNumber().equals(accNum) && accounts[i].getPin().equals(pin)) {
				return accounts[i];
			}
		}
		return null;
	}
    public void withdraw(Account account,double amount) throws InsufficientBalance {
    	ConsoleColors dd=new ConsoleColors();
    		if(amount>account.getBalance() || amount<0) {
    			throw new InsufficientBalance(dd.RED+"Insufficient balance..!! Deposite balance"+dd.RED);
    		}
    		else{
    			account.setBalance(account.getBalance()-amount);
    			System.out.println("Amount Withdrawn successfully!... ");	
    			System.out.println("................................");
    		}
    }

    public void deposit(Account account,double amount)throws InsufficientBalance  {
    	ConsoleColors dd=new ConsoleColors();
    	 if (amount >=100) {
             account.setBalance(account.getBalance() + amount);
             System.out.println("\nDeposit successful!\n");
         } else {
            throw new InsufficientBalance(dd.RED+"Invalid Amount! plz deposit amount"+dd.RED);
         }
    }

    public double checkBalance(Account account) {
    	 return account.getBalance();
    }

}
