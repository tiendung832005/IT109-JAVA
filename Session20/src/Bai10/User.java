package Bai10;

import java.util.Optional;

class User {
    private int id;
    private String name;
    private Optional<String> email;

    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = Optional.ofNullable(email);
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public Optional<String> getEmail() { return email; }

    public String getEmailDisplay() {
        return email.orElse("Không có email");
    }
}