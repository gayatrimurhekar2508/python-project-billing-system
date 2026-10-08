public class BankAccount {
    private String accountHolder;
    private String accountNumber;
    private double balance;

    public BankAccount(String accountHolder, String accountNumber, double initialBalance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = Math.max(initialBalance, 0);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("₹%.2f deposited successfully.%n", amount);
        } else System.out.println("Deposit amount must be greater than 0.");
    }

    public void withdraw(double amount) {
        if (amount <= 0) System.out.println("Withdrawal amount must be greater than 0.");
        else if (amount > balance) System.out.println("Insufficient balance.");
        else {
            balance -= amount;
            System.out.printf("₹%.2f withdrawn successfully.%n", amount);
        }
    }

    public void displayBalance() {
        System.out.printf("Account Holder : %s%nAccount Number : %s%nCurrent Balance: ₹%.2f%n",
                accountHolder, accountNumber, balance);
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount("Gayatri", "SB1001", 5000);
        System.out.println("===== BANK ACCOUNT =====");
        account.displayBalance();
        account.deposit(1500);
        account.withdraw(1000);
        System.out.println("--- Final Balance ---");
        account.displayBalance();
    }
}
