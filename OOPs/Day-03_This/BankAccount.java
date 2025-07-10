public class BankAccount {

    static String bankName = "OpenAI Bank";
    private static int totalAccounts = 0;

    private final String accountNumber;
    private String accountHolderName;

    public BankAccount(String accountNumber, String accountHolderName) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        totalAccounts++;
    }

    public static void getTotalAccounts() {
        System.out.println("Total accounts in " + bankName + ": " + totalAccounts);
    }

    public void displayDetails() {
        if (this instanceof BankAccount) {
            System.out.println("Bank Name: " + bankName);
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Account Holder: " + accountHolderName);
        } else {
            System.out.println("Invalid account object.");
        }
    }

    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("123456", "Alice");
        BankAccount acc2 = new BankAccount("789012", "Bob");

        acc1.displayDetails();
        System.out.println();

        acc2.displayDetails();
        System.out.println();

        BankAccount.getTotalAccounts();
    }
}