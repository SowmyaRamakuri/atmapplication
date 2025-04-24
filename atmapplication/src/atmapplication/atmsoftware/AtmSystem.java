package atmapplication.atmsoftware;

import java.util.Scanner;

public class AtmSystem {
	
	ConsoleColors cc=new ConsoleColors();
		 Scanner sc=new Scanner(System.in);
		 Account[] accounts = new Account[100];
		 int accountCount=0;
		
		 AdminLogin admin = new AdminLogin();
		 ATM atm = new ATM();
		 public void atm_start() throws InvalidCredientials, InsufficientBalance {
				while(true) {
					System.out.println(cc.BLUE+" Welcome to ATM System "+cc.BLUE);
					System.out.println(cc.GREEN+"1. Create Account\n2. Admin Login\n3. Account Login\n4. Exit"+cc.GREEN);
					System.out.print("Enter your Choice: ");
					int choice = sc.nextInt(); sc.nextLine();
					switch(choice) {
					case 1: createAccount(); break;
					case 2: try {
							adminLogin();
						} catch (InvalidCredientials e) {
							
							e.printStackTrace();
						} catch (NoAccount e) {
							
							e.printStackTrace();
						} break;
					case 3: accountLogin(); break;
					case 4: System.out.println( "Exit"); return;
					default: System.out.println("Enter the valid choice");
					}
				}
			}
			//=======   Account creation   =================
			public void createAccount() {
				System.out.println(cc.Black+"You are pleased to fill the following Details"+cc.YELLOW);
				System.out.println("...............................................");
				System.out.print("Enter your username: ");
				String userName = sc.nextLine();
				System.out.print("Enter Location: ");
				String location = sc.nextLine();
				System.out.print("Enter Account Number: ");
				String accountNum = sc.nextLine();
				System.out.print("Enter PIN: ");
				String pin  =sc.nextLine();
				System.out.print("Enter initial Balance: ");
				double balance = sc.nextDouble();
				sc.nextLine();
				  if (userName.isEmpty() || location.isEmpty() || accountNum.isEmpty() || pin.isEmpty() || balance < 0) {
				        System.out.println( cc.RED+"Error:Fill all deatails"+cc.RED );
				        return;
				    }
					accounts[accountCount++]=new Account(userName,location,accountNum,pin,balance);
					System.out.println("Account created Successfully");
					
				
			}
			// ======= admin login ======
			public void adminLogin() throws InvalidCredientials, NoAccount {
				System.out.print(cc.Black+"Enter Password: "+cc.PINK);
				String pass =sc.nextLine();
				if(admin.login(pass)) {
					System.out.println("-------Admin Login Successfully-------");
					while(true) {
						System.out.println("1. View All Accounts\n2. Delete Account\n3. LogOut");
						System.out.print("Enter your choice: ");
						int choice = sc.nextInt();sc.nextLine();
						switch(choice) {
						case 1: try {
								admin.viewAllAccounts(accounts,accountCount);
							} catch (NoAccount e) {
								
								e.printStackTrace();
							} break;
						case 2: if(accountCount>0) {
								admin.viewAllAccounts(accounts, accountCount);
								System.out.print("Enter Account number to Delete: ");
								String accNum = sc.nextLine();
								int count=admin.deleteAccount(accounts,accountCount,accNum);
								if(count!=accountCount) {
									accountCount=count;
								}
								}else {
									throw new NoAccount(cc.RED+"***No Accounts to Delete***"+cc.RED);
								}break;
						case 3: System.out.println("Logging Out...");return;
						default:System.out.println("please enter valid choice......");
						}
					}
				}else {
					throw new InvalidCredientials(cc.RED+" Invalid Credientials......."+cc.RED);
				}
			}
			//user login
			public void accountLogin() throws InvalidCredientials, InsufficientBalance {
				ConsoleColors cc=new ConsoleColors();
				
				
				System.out.print(cc.Black+"Enter Account Number: " +cc.Cyan);
				String accNum = sc.nextLine();
				System.out.print("Enter Your Pin: ");
				String pin = sc.nextLine();
				Account account = atm.authenticate(accounts, accountCount, accNum, pin);
				if(account!=null) {
					System.out.println("Login Successfull "+account.getUsername());
					while(true) {
						 System.out.println("1. Withdraw\n2. Deposit\n3. Check Balance\n4. Logout");
						 System.out.print("Enter your choice: ");
			             int choice = sc.nextInt(); sc.nextLine();
			             switch(choice) {
			             case 1: System.out.print(cc.Black+"Enter Amount to Withdraw: "+cc.Black);
			                        try {
					             atm.withdraw(account, sc.nextDouble());
					             sc.nextLine(); break;
			                        }catch(InsufficientBalance i) {
			                        	i.printStackTrace();
			                        }
			             case 2:  System.out.print(cc.Black+"Enter Amount to Deposit: " +cc.Black);
			             			atm.deposit(account, sc.nextDouble());
			             			sc.nextLine(); break;
			             case 3: System.out.println(atm.checkBalance(account)); break;
			             case 4: System.out.println("Logging Out..!"+cc.GREEN); return;
			             default: System.out.println(cc.RED+"Invalid choice..!"+cc.RED);
			             }
					}
				}else {
					throw new InvalidCredientials(cc.RED+"Invalid crediential!plz enter valid crediential"+cc.RED);
				}
			}
			public static void main(String[] args) throws InvalidCredientials, InsufficientBalance {
				AtmSystem atmsys = new AtmSystem();
				atmsys.atm_start();
				
			}
		}
		 
		


