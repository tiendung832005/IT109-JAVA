package Bai7;

import Bai7.service.TransactionIsolationTestService;

public class Bai7 {
    public static void main(String[] args) {
        TransactionIsolationTestService service = new TransactionIsolationTestService();

        try {
            service.createOrdersTable();

            // Thử nghiệm với các isolation level khác nhau
            System.out.println("===== READ_UNCOMMITTED TEST =====");
            service.testIsolationLevel(java.sql.Connection.TRANSACTION_READ_UNCOMMITTED);

            System.out.println("\n===== READ_COMMITTED TEST =====");
            service.testIsolationLevel(java.sql.Connection.TRANSACTION_READ_COMMITTED);

            System.out.println("\n===== REPEATABLE_READ TEST =====");
            service.testIsolationLevel(java.sql.Connection.TRANSACTION_REPEATABLE_READ);

            System.out.println("\n===== SERIALIZABLE TEST =====");
            service.testIsolationLevel(java.sql.Connection.TRANSACTION_SERIALIZABLE);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            service.cleanup();
        }
    }
}
