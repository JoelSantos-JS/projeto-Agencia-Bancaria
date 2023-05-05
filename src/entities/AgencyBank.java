import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.sound.midi.Soundbank;
import javax.swing.JOptionPane;

public class AgencyBank {
    // static Scanner sc = new Scanner(System.in);
    static List<Account> accounts = new ArrayList<>();
    private static Account account;

    private Pessoa pessoa;

    public static void main(String[] args) {
        

        operation();
    }


    public static void operation() {
       
        int operation = Integer.parseInt(JOptionPane.showInputDialog("--- Select an option ---\n"+
       "1. Create Account"+
        "2. Deposit"+
        "3. Withdraw"+
        "4. Transfer"+
        
        "5. Check Balance"+
        "6. listAccount"+
        "7. Credit"+
        "8. Debit"+
        "9: Exit"
        
        ));

     
        
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
            case 7:
            credit();
            case 8:
            debit();
            case  9:
            JOptionPane.showMessageDialog(null, "Thank you for using our service");
            System.out.println();
            System.exit(0);


            default:
            JOptionPane.showMessageDialog(null, "Invalid option");
            
            operation();
        
        }


        
    }
    	
    public static void createAcount() {
        Pessoa pessoa = new Pessoa(null, null, null);

       pessoa.setNome( JOptionPane.showInputDialog(null, "Enter your name"));
        
        pessoa.setCpf(JOptionPane.showInputDialog(null, "Enter your cpf"));

        pessoa.setEmail(JOptionPane.showInputDialog(null, "Enter your email"));
      

        
    
        Account account = new Account(pessoa);

        accounts.add(account);

        JOptionPane.showMessageDialog(null, "Your account has been created");

        

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

    int accountNumber = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the account number"));




    

    double amount = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the amount to deposit"));
    Account account = findAccount(accountNumber);

    if(account != null) {
        account.deposit(amount);
    } else {
        JOptionPane.showMessageDialog(null, "Invalid account number");
        
    }

    operation();
} 


public static void withdraw() {
    int  accountNumber = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the account number"));

    
    double amount = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the amount to withdraw"));
  
    Account account = findAccount(accountNumber);

    if(account != null) {
        
        double amount2 = Double.parseDouble( JOptionPane.showInputDialog(null, "how much do you want to withdraw")
        );
        account.withdraw(amount2);
        JOptionPane.showMessageDialog(null, "withdraw successfully");
        
    }else {
        JOptionPane.showMessageDialog(null, "Invalid account number");

    
    }

    operation();
}


public static void transfer() {
    int yourAccountNumber = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the account number to transfer"));

  
    Account account2 = findAccount(yourAccountNumber);

    double amount = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the amount to transfer"));


    if(account2 != null) {
        
        
        int destinationAccountNumber  = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the account number the destination"));
        Account account = findAccount(destinationAccountNumber);

        if(account != null) {
            account2.transfer(amount, account);
        }
    
    }else {

        JOptionPane.showMessageDialog(null, "Invalid account number");

    }


    operation();

}

public static void checkBalance() {
    

    int account = Integer.parseInt(    JOptionPane.showInputDialog(null, "Enter account number ")
    );
    Account account2 = findAccount(account);

    if(account2 != null) {
        JOptionPane.showMessageDialog(null, "Your balance is" + account2.getBalance());
       
    }else {
        JOptionPane.showMessageDialog(null, "Invalid account number");
      
    }



operation();


}

public static void listAccount() {
    if(accounts.size() > 0) {
        for (Account account : accounts) {
            System.out.println(account);
        }
    }else {
        JOptionPane.showMessageDialog(null, "No accounts found");

    }

    operation();



}

private static void availableToCredit2() {
    for (Account account : accounts) {
        if(account.getBalance() > 850) {
            JOptionPane.showMessageDialog(null, "This value is available" + account.getBalance() * 3);
            

    
        }
            }


}



public static void availableToCredit(double amount) {
    

    if(accounts.size() > 0) {
        for (Account account2 : accounts) {
            
            if(account2.getBalance() > account2.getBalance() - amount) {
              

               account2.setBalance(account2.getBalance() + amount);
                              
            }else {

                JOptionPane.showMessageDialog(null, "you dont have enough money for the credit" );
            
                
               
            }
        }
    }

}



public static void  credit() {
    int accountNumber = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the account number "));

    for (Account account : accounts) {
        if(account.getAccountNumber() == accountNumber) {

            if(account.getBalance() > 850) {
                availableToCredit2();

               
                double amount = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the amount to credit"));
                availableToCredit(amount);
            }else {

                JOptionPane.showMessageDialog(null, "you dont have enough money for the credit" );
            }

          

            ;
        
        }


    }

    operation();
    

 
   
}

public static void debit() {

}

    
}
