public class BankAccount {
    private final String accountNumber;
    private double balance;
    private String ownerName;

    BankAccount(String accountNumber, String ownerName) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = 0;
    }
    BankAccount(String accountNumber, String ownerName, int balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        if(balance < 0) {
            System.out.println("Balance error!");
            this.balance = 0;
        }
        else
            this.balance = balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public boolean withdraw(double amount) {
        if (this.balance >= amount) {
            this.balance -= amount;
            return true;
        }
        return false;
    }

    public double getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        BankAccount Person = new BankAccount("25021642", "Tai Anh", -1);
        System.out.println(Person.withdraw(10));
        Person.deposit(20);
        System.out.println(Person.withdraw(10));
        // Person.accountNumber = "siuu";
    }
}
