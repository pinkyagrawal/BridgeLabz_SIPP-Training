import java.util.*;

class Account {
    private String accountNumber;
    private double balance;
    private Bank bank;

    public Account(String accountNumber, double initialDeposit, Bank bank) {
        this.accountNumber = accountNumber;
        this.balance = initialDeposit;
        this.bank = bank;
    }

    public double getBalance() {
        return balance;
    }

    public String getBankName() {
        return bank.getBankName();
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}

class Customer {
    private String name;
    private List<Account> accounts;

    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void viewBalance() {
        System.out.println("Account details for " + name + ":");
        for (Account acc : accounts) {
            System.out.println("Bank: " + acc.getBankName() + ", Account No: " + acc.getAccountNumber() + ", Balance: ₹"
                    + acc.getBalance());
        }
        System.out.println();
    }

    public String getName() {
        return name;
    }
}

class Bank {
    private String bankName;
    private List<Customer> customers;

    public Bank(String bankName) {
        this.bankName = bankName;
        this.customers = new ArrayList<>();
    }

    public String getBankName() {
        return bankName;
    }

    public void openAccount(Customer customer, String accountNumber, double initialDeposit) {
        Account newAccount = new Account(accountNumber, initialDeposit, this);
        customer.addAccount(newAccount);
        if (!customers.contains(customer)) {
            customers.add(customer);
        }
        System.out.println(
                "Account opened for " + customer.getName() + " at " + bankName + " with Account No: " + accountNumber);
    }

    public void listCustomers() {
        System.out.println("Customers of " + bankName + ":");
        for (Customer customer : customers) {
            System.out.println("- " + customer.getName());
        }
        System.out.println();
    }
}

public class AssociationExample {
    public static void main(String[] args) {
        Bank bank1 = new Bank("Axis Bank");
        Bank bank2 = new Bank("HDFC Bank");

        Customer cust1 = new Customer("Alice");
        Customer cust2 = new Customer("Bob");

        bank1.openAccount(cust1, "AX1001", 5000);
        bank1.openAccount(cust2, "AX1002", 7000);

        bank2.openAccount(cust1, "HD2001", 10000); 

        System.out.println();
        bank1.listCustomers();
        bank2.listCustomers();

        cust1.viewBalance();
        cust2.viewBalance();
    }
}