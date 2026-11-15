public class Main {
    public static void main(String[] args) {
        BankAccount a1 = new BankAccount("noam", 1000.0);
        BankAccount a2 = new BankAccount("mor", 500.0);

        System.out.println(a1.getAccountId());
        System.out.println(a2.getAccountId());

        a1.deposit(500.0);
        a2.withdraw(200.0);
        a1.transferTo(a2, 300.0);

        a1.withdraw(5000.0);

        System.out.println(a1.getAccountInfo());
        System.out.println(a2.getAccountInfo());

        System.out.println(BankAccount.getTotalAccounts());

        System.out.println(BankAccount.getNextAccountId());
        BankAccount a3 = new BankAccount("ori", 200.0);
        System.out.println(a3.getAccountId());

        a1.deposit(-50.0);
        a1.transferTo(a1, 100.0);

        Bank myBank = new Bank("Hapoalim", 12);
        myBank.setAccounts(a1, a2);

        System.out.println(myBank.getBankInfo());
        System.out.println(myBank.getTotalBalance());
    }
}