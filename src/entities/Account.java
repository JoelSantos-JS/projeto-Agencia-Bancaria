import utils.Utils;

public class Account {

    private static int countAccount = 0;

    private int accountNumber;
    private Pessoa pessoa;
    private double balance = 0.0;


    public Account(int accountNumber, Pessoa pessoa, double balance) {
        this.accountNumber = accountNumber;
        this.pessoa = pessoa;
        this.balance = balance;
        countAccount += 1;
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


    @Override
    public String toString() {
        return "Account [accountNumber=" + accountNumber + ", pessoa=" + pessoa + ", balance=" + Utils.doubleToString(balance) + "]";
    }


    public void deposit(double value) {
        if(value > 0) {
            setBalance(value);
        }

    }
    

    

    
}
