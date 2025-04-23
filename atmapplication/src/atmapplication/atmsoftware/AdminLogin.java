package atmapplication.atmsoftware;

public class AdminLogin {
private static final String ADMIN_PIN = "Admin123";
    
    public boolean login(String enteredPin) {
        return ADMIN_PIN.equals(enteredPin);
    }
    
    public void viewAllAccounts(Account[] accounts, int accountCount) throws NoAccount {
    	
    	if (accountCount == 0) {
            throw new NoAccount( "No accounts found!" );
            
        }

        System.out.println( "****** ALL USER ACCOUNTS ******" );
        for (int i = 0; i < accountCount; i++) {
        	 System.out.println("\nAccount: "+accounts[i].getAccountNumber()+
        			 " \n Name: "+accounts[i].getUsername()+
        			 "\n Location:"+accounts[i].getLocation()+
        			 "\n Balance:"+accounts[i].getBalance());
        }
       
    }

  
    public int deleteAccount(Account[] accounts, int accountCount,String accountNumber) throws NoAccount {
    	 boolean found=false;
    	for(int i=0;i<accountCount;i++) {
			if(accounts[i].getAccountNumber().equals(accountNumber)) {
				accounts[i]=null;
				accountCount--;
				System.out.println("Account Deleted Successfully..");
				System.out.println("********************************");
				found=true;
				break;
			}		
    }
    	if(!found) {
    		throw new NoAccount("******************Account not found***********");
    	}

    return accountCount;
}
}
