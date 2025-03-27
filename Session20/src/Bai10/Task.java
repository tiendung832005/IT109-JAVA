package Bai10;

import java.time.LocalDate;

class Task {
    private int id;
    private String title;
    private User assignedTo;
    private LocalDate dueDate;
    private boolean completed;

    public Task(int id, String title, User assignedTo, LocalDate dueDate, boolean completed) {
        this.id = id;
        this.title = title;
        this.assignedTo = assignedTo;
        this.dueDate = dueDate;
        this.completed = completed;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public User getAssignedTo() { return assignedTo; }
    public LocalDate getDueDate() { return dueDate; }
    public boolean isCompleted() { return completed; }

    public boolean isOverdueAndNotCompleted() {
        return !completed && dueDate.isBefore(LocalDate.of(2025, 3, 23));
    }
}
