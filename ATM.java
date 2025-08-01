import java.util.*;

class BankAccount {
    private double balance;
    BankAccount(double bal) { balance = bal; }
    void deposit(double amt) { balance += amt; }
    boolean withdraw(double amt) {
        if (amt > balance) return false;
        balance -= amt;
        return true;
    }
    double getBalance() { return balance; }
}

class ATM {
    private BankAccount account;
    ATM(BankAccount acc) { account = acc; }
    void menu() {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1.Withdraw\n2.Deposit\n3.Check Balance\n4.Exit");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Amount to withdraw: ");
                    double w = sc.nextDouble();
                    if (account.withdraw(w))
                        System.out.println("Withdrawn. Balance: " + account.getBalance());
                    else
                        System.out.println("Insufficient funds!");
                    break;
                case 2:
                    System.out.print("Amount to deposit: ");
                    account.deposit(sc.nextDouble());
                    System.out.println("Deposited. Balance: " + account.getBalance());
                    break;
                case 3:
                    System.out.println("Current Balance: " + account.getBalance());
                    break;
            }
        } while (choice != 4);
        sc.close();
    }
    public static void main(String[] args) {
        BankAccount acc = new BankAccount(1000); // Initial balance
        ATM atm = new ATM(acc);
        atm.menu();
    }
}
