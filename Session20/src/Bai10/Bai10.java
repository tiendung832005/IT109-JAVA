package Bai10;

import java.time.LocalDate;
import java.util.List;

public class Bai10 {
    public static void main(String[] args) {
        User u1 = new User(1, "Quý", "quy@example.com");
        User u2 = new User(2, "Lan", null);
        User u3 = new User(3, "Huyền", "huyen@example.com");

        List<Task> tasks = List.of(
                new Task(1, "Viết báo cáo", u1, LocalDate.of(2025, 3, 20), false),
                new Task(2, "Thiết kế slide", u1, LocalDate.of(2025, 3, 25), true),
                new Task(3, "Họp nhóm", u2, LocalDate.of(2025, 3, 18), false),
                new Task(4, "Nộp tài liệu", u3, LocalDate.of(2025, 3, 22), true),
                new Task(5, "Chuẩn bị thuyết trình", u2, LocalDate.of(2025, 3, 19), true)
        );

        System.out.println("Danh sách công việc quá hạn và chưa hoàn thành:");
        tasks.stream()
                .filter(Task::isOverdueAndNotCompleted)
                .forEach(task -> System.out.println(task.getTitle() + " - Người được giao: " + task.getAssignedTo().getName()));

        long completedTaskCount = tasks.stream()
                .filter(Task::isCompleted)
                .count();
        System.out.println("\nTổng số công việc đã hoàn thành: " + completedTaskCount);

        System.out.println("\nThông tin người dùng:");
        List<User> users = List.of(u1, u2, u3);
        users.forEach(user -> {
            long totalAssignedTasks = tasks.stream()
                    .filter(task -> task.getAssignedTo().equals(user))
                    .count();

            long overdueAndNotCompletedTasks = tasks.stream()
                    .filter(task -> task.getAssignedTo().equals(user) && task.isOverdueAndNotCompleted())
                    .count();

            System.out.println("Tên: " + user.getName() +
                    ", Email: " + user.getEmailDisplay() +
                    ", Tổng công việc: " + totalAssignedTasks +
                    ", Công việc quá hạn: " + overdueAndNotCompletedTasks);
        });
    }
}
