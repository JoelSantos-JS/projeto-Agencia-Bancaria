import utils.Utils;

public class Account {

    private static int countAccount = 1;

    private int accountNumber;
    private Pessoa pessoa;
    private double balance = 0.0;


  

    public Account( Pessoa pessoa) {
        this.accountNumber += countAccount ;
        this.pessoa = pessoa;
        this.updateBalance();;
        Account.countAccount += 1;
    }


    public static int getCountAccount() {
        return countAccount;
    }


    public static void setCountAccount(int countAccount) {
        Account.countAccount = countAccount;
    }


    public int getAccountNumber() {
        return accountNumber;
    }


    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }


    public Pessoa getPessoa() {
        return pessoa;
    }


    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }


    public double getBalance() {
        return balance;
    }


    public void setBalance(double balance) {
        this.balance = balance;
    }


    public void updateBalance( ) {
        this.balance = this.getBalance();
    }

    @Override
    public String toString() {
        return "Account [accountNumber=" + accountNumber + ", pessoa=" + pessoa + ", balance=" + Utils.doubleToString(balance) + "]";
    }


    public void deposit(double value) {
        if(value > 0) {
            setBalance(getBalance() + value);

            System.out.println("Deposit made successfully with value: " + Utils.doubleToString(value));
        }else {
            System.out.println("Its not possible realize the deposit");
        }

    }

    public void withdraw(double value) {
        if(value > 0 && this.getBalance() >= value) {
            setBalance(getBalance() - value);

            System.out.println("Withdraw made successfully with value: " + Utils.doubleToString(value));
        }
           
    }


    public void transfer(Double value, Account account) {
        if(value > 0 && this.getBalance() >= value) {
            setBalance(getBalance() - value);

            account.balance = account.getBalance() + value;

            System.out.println("Transfer made successfully with value: " + Utils.doubleToString(value)); 
        } 

    }


    

    

    
}
