package Bai1;

public class bai1 {
    public static void main(String[] args) {
        Account account1 = Account.getInstance();
        System.out.println("account1: " + account1);

        account1.setId(100);
        account1.setName("John Doe");
        account1.setAge(25);
        System.out.println("account1 sau khi thay đổi: " + account1);

        Account account2 = Account.getInstance();
        System.out.println("account2: " + account2);

        System.out.println("account1 == account2: " + (account1 == account2));

        account2.setName("Jane Smith");
        System.out.println("account2 sau khi thay đổi tên: " + account2);
        System.out.println("account1 sau khi thay đổi account2: " + account1);
    }
}
