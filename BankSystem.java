// Base class for Account
class Account {
    private static int accountCounter = 1000; // Static counter for unique account numbers
    protected String accountHolderName;
    protected int accountNumber;
    protected double balance;

    // Constructor
    public Account(String accountHolderName, double initialDeposit) {
        this.accountHolderName = accountHolderName;
        this.balance = initialDeposit;
        this.accountNumber = ++accountCounter; // Generate unique account number
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdrawal method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds.");
        }
    }

    // Method to display account details
    public void displayAccountDetails() {
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);
    }
}

// Derived class for Savings Account
class SavingsAccount extends Account {
    private static final double INTEREST_RATE = 0.03; // 3% annual interest rate

    public SavingsAccount(String accountHolderName, double initialDeposit) {
        super(accountHolderName, initialDeposit);
    }

    // Method to apply interest
    public void applyInterest() {
        double interest = balance * INTEREST_RATE;
        balance += interest;
        System.out.println("Interest applied: $" + interest);
    }
}

// Main class
public class BankSystem {
    public static void main(String[] args) {
        // Create a new savings account
        SavingsAccount account1 = new SavingsAccount("John Doe", 500.0);

        // Display account details
        account1.displayAccountDetails();

        // Perform deposit
        account1.deposit(200.0);

        // Perform withdrawal
        account1.withdraw(150.0);

        // Apply interest
        account1.applyInterest();

        // Display updated account details
        account1.displayAccountDetails();

        // Create another savings account
        SavingsAccount account2 = new SavingsAccount("Jane Smith", 1000.0);
        account2.displayAccountDetails();
    }
}
