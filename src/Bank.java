public class Bank {
    private String bankName;
    private int bankCode;
    private BankAccount account1;
    private BankAccount account2;

    public Bank(String name, int code) {
        bankName = name;
        bankCode = code;
        account1 = null;
        account2 = null;
    }

    public void setAccounts(BankAccount a, BankAccount b) {
        account1 = a;
        account2 = b;
    }

    public double getTotalBalance() {
        double total = account1.getBalance() + account2.getBalance();
        return total;
    }

    public String getBankInfo() {
        return "Bank Name: " + bankName + ", Bank Code: " + bankCode +
                "\nFirst Account: " + account1.getAccountInfo() +
                "\nSecond Account: " + account2.getAccountInfo();
    }

    public String getBankName() {
        return bankName;
    }
}
