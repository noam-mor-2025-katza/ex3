public class BankAccount {
    private int accountId;
    private String ownerName;
    private double balance;
    private boolean isActive;
    private static int nextId = 1000;
    private static int totalAccounts = 0;

    BankAccount(String ownerName){
        this.ownerName = ownerName;
        this.accountId = nextId++;
        this.isActive = true;
        this.balance = 0.0;
        totalAccounts++;
    }

    BankAccount(String ownerName, double initialBalance){
        this.ownerName = ownerName;
        this.accountId = nextId++;
        this.isActive = true;
        if(initialBalance < 0){
            this.balance = 0.0;
        } else {
            this.balance = initialBalance;
        }
        totalAccounts++;
    }

    // Static methods
    public static int getTotalAccounts() {
        return totalAccounts;
    }

    public static boolean isValidAmount(double amount) {
        return amount > 0;
    }

    public static int getNextAccountId() {
        return nextId;
    }

    public boolean deposit(double amount) {
        if (!isActive || !isValidAmount(amount)) {
            return false;
        }
        balance += amount;
        return true;
    }

    public boolean withdraw(double amount) {
        if (!isActive || !isValidAmount(amount) || balance < amount) {
            return false;
        }
        balance -= amount;
        return true;
    }

    public boolean transferTo(BankAccount destination, double amount) {
        if (destination == null || destination == this) {
            return false;
        }
        if (!isActive || !destination.isActive || !isValidAmount(amount) || balance < amount) {
            return false;
        }
        balance -= amount;
        destination.balance += amount;
        return true;
    }

    public boolean closeAccount() {
        if (!isActive || balance != 0) {
            return false;
        }
        isActive = false;
        return true;
    }

    public String getAccountInfo() {
        return "Account id: " + accountId + ", owner Name: " + ownerName + ", balance: " + balance + ", Active: " + isActive;
    }

    public int getAccountId() {
        return accountId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        if (ownerName != null && !ownerName.equals("")) {
            this.ownerName = ownerName;
        }
    }

    public double getBalance() {
        return balance;
    }

    public boolean isActive() {
        return isActive;
    }

}