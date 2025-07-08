// Superclass
class BankAccount {
    String accountNumber;
    double balance;

    BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
}

// Subclass 1
class SavingsAccount extends BankAccount {
    double interestRate;

    SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    void displayAccountType() {
        System.out.println("Savings Account");
    }
}

// Subclass 2
class CheckingAccount extends BankAccount {
    double withdrawalLimit;

    CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    void displayAccountType() {
        System.out.println("Checking Account");
    }
}

// Subclass 3
class FixedDepositAccount extends BankAccount {
    int durationMonths;

    FixedDepositAccount(String accountNumber, double balance, int durationMonths) {
        super(accountNumber, balance);
        this.durationMonths = durationMonths;
    }

    void displayAccountType() {
        System.out.println("Fixed Deposit Account");
    }
}

// Test
public class BankSystem {
    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount("SAV123", 10000, 5.5);
        sa.displayAccountType();

        CheckingAccount ca = new CheckingAccount("CHK456", 15000, 5000);
        ca.displayAccountType();

        FixedDepositAccount fda = new FixedDepositAccount("FD789", 20000, 12);
        fda.displayAccountType();
    }
}
