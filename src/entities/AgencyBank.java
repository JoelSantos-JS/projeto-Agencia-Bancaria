import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AgencyBank {
    static Scanner sc = new Scanner(System.in);
    static List<Account> accounts = new ArrayList<>();

    public static void main(String[] args) {
        

        operation();
    }


    public static void operation() {
        System.out.println("........................................................");
        System.out.println("................... Welcome to Agency Bank...............");
        System.out.println("********* Select your option *********");
        System.out.println("........................................................");
        System.out.println("1. Create Account");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Transfer");
        System.out.println("5. Check Balance");
        System.out.println("6. listAccount");
        System.out.println("7. Exit");


        int operation  = sc.nextInt();

        switch(operation) {
            
            case 1: 
            createAcount();
            break;
            case 2:
            deposit();
            break;
            case 3:
            withdraw();
            break;
            case 4:
            transfer();
            break;
            case 5:
            checkBalance();
            break;
            case 6:
            listAccount();
            case  7:
            System.out.println("Thank you for using our service");
            System.exit(0);


            default:
            System.out.println("Invalid option");
            operation();
        
        }


        
    }
    	
    public static void createAcount() {
        System.out.println("Enter your name");

        String name = sc.next();

        System.out.println("Enter your cpf");
        String cpf = sc.next();
        System.out.println("Enter your Email");
        String email = sc.next();

        Pessoa pessoa = new Pessoa(name, cpf, email);
        Account account = new Account(pessoa);

        accounts.add(account);

        System.out.println("Your account has been created");

        operation();

    }


    private static Account findAccount(int accountNumber) {
       Account account = null;

       if(accounts.size() > 0) {
        for (Account account2 : accounts) {
            if(account2.getAccountNumber() == accountNumber) {
                account = account2;
            }
        
       }
    } 

    return account;
}


public static void deposit() {
 System.out.println("Enter the account number");
    int accountNumber = sc.nextInt();
    System.out.println("Enter the amount to deposit");
    double amount = sc.nextDouble();

    Account account = findAccount(accountNumber);

    if(account != null) {
        account.deposit(amount);
    } else {
        System.out.println("Invalid account number");
    }

    operation();
} 


public static void withdraw() {
    System.out.println("Enter the account number");
    int accountNumber2 = sc.nextInt();

    System.out.println("Enter the amount to withdraw");
    double amount = sc.nextDouble();
    Account account = findAccount(accountNumber2);

    if(account != null) {
        System.out.println("how much do you want to withdraw");
        double amount2 = sc.nextDouble();
        account.withdraw(amount2);
        System.out.println("withdraw successfully");
    }else {
        System.out.println("Invalid account number");
    
    }

    operation();
}


public static void transfer() {
    System.out.println("Enter the account number to transfer");
    int yourAccountNumber  = sc.nextInt();
    Account account2 = findAccount(yourAccountNumber);
    System.out.println("Enter the amount to transfer");
    double amount = sc.nextDouble();


    if(account2 != null) {
        System.out.println("Enter account number the destination");
        int destinationAccountNumber  = sc.nextInt();
        Account account = findAccount(destinationAccountNumber);

        if(account != null) {
            account.transfer(amount, account2);
        }
    
    }else {

        System.out.println("Invalid account number");
    }


    operation();

}

public static void checkBalance() {
    System.out.println("Enter the account number");
    int account = sc.nextInt();
    Account account2 = findAccount(account);

    if(account2 != null) {
        System.out.println("Your balance is " + account2.getBalance());
    }else {
        System.out.println("Invalid account number");
    }



operation();


}

public static void listAccount() {
    if(accounts.size() > 0) {
        for (Account account : accounts) {
            System.out.println(account);
        }
    }else {
        System.out.println("No accounts found");
    }

    operation();



}

    
}