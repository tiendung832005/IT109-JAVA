import java.util.Map;
import java.util.TreeMap;

public class Bai4 {
    public static void main(String[] args) {
        TreeMap<String, Double> employeeSalaries = new TreeMap<>();

        employeeSalaries.put("NV123", 10000000.0);
        employeeSalaries.put("NV456", 12000000.0);
        employeeSalaries.put("NV089", 15000000.0);
        employeeSalaries.put("NV234", 9000000.0);
        employeeSalaries.put("NV567", 13500000.0);

        System.out.println("Danh sách nhân viên ban đầu (theo thứ tự mã nhân viên tăng dần):");
        printEmployees(employeeSalaries);

        String employeeToUpdate = "NV123";
        double newSalary = 11000000.0;

        if (employeeSalaries.containsKey(employeeToUpdate)) {
            employeeSalaries.put(employeeToUpdate, newSalary);
            System.out.println("\nĐã cập nhật mức lương của nhân viên " + employeeToUpdate +
                    " thành " + String.format("%,.0f", newSalary) + " VNĐ");
        } else {
            System.out.println("\nKhông tìm thấy nhân viên " + employeeToUpdate + " để cập nhật");
        }

        System.out.println("\nDanh sách nhân viên sau khi cập nhật:");
        printEmployees(employeeSalaries);

        String employeeToRemove = "NV234";

        if (employeeSalaries.containsKey(employeeToRemove)) {
            employeeSalaries.remove(employeeToRemove);
            System.out.println("\nĐã xóa nhân viên " + employeeToRemove);
        } else {
            System.out.println("\nKhông tìm thấy nhân viên " + employeeToRemove + " để xóa");
        }

        System.out.println("\nDanh sách nhân viên sau khi xóa:");
        printEmployees(employeeSalaries);
    }

    private static void printEmployees(TreeMap<String, Double> employees) {
        for (Map.Entry<String, Double> entry : employees.entrySet()) {
            System.out.println("Mã nhân viên: " + entry.getKey() +
                    ", Lương: " + String.format("%,.0f", entry.getValue()) + " VNĐ");
        }
    }
}