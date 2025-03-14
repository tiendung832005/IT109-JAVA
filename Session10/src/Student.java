
class Student {
    private String name;
    private String id;
    private double gpa;

    public Student(String name, String id, double gpa) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Tên sinh viên không được để trống");
        }
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Mã sinh viên không được để trống");
        }
        if (gpa < 0 || gpa > 10) {
            throw new IllegalArgumentException("Điểm GPA phải nằm trong khoảng từ 0 đến 10");
        }

        this.name = name;
        this.id = id;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Tên sinh viên không được để trống");
        }
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Mã sinh viên không được để trống");
        }
        this.id = id;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        if (gpa < 0 || gpa > 10) {
            throw new IllegalArgumentException("Điểm GPA phải nằm trong khoảng từ 0 đến 10");
        }
        this.gpa = gpa;
    }

    public String getDetails() {
        return "Tên: " + name + ", Mã sinh viên: " + id + ", Điểm trung bình: " + gpa;
    }
}

class GraduateStudent extends Student {
    // Thuộc tính
    private String researchTopic;
    private String supervisorName;

    public GraduateStudent(String name, String id, double gpa, String researchTopic, String supervisorName) {
        super(name, id, gpa);

        if (researchTopic == null || researchTopic.trim().isEmpty()) {
            throw new IllegalArgumentException("Đề tài nghiên cứu không được để trống");
        }
        if (supervisorName == null || supervisorName.trim().isEmpty()) {
            throw new IllegalArgumentException("Tên giảng viên không được để trống");
        }

        this.researchTopic = researchTopic;
        this.supervisorName = supervisorName;
    }

    public String getResearchTopic() {
        return researchTopic;
    }

    public void setResearchTopic(String researchTopic) {
        if (researchTopic == null || researchTopic.trim().isEmpty()) {
            throw new IllegalArgumentException("Đề tài nghiên cứu không được để trống");
        }
        this.researchTopic = researchTopic;
    }

    public String getSupervisorName() {
        return supervisorName;
    }

    public void setSupervisorName(String supervisorName) {
        if (supervisorName == null || supervisorName.trim().isEmpty()) {
            throw new IllegalArgumentException("Tên giảng viên hướng dẫn không được để trống");
        }
        this.supervisorName = supervisorName;
    }


    @Override
    public String getDetails() {
        // Sử dụng super để gọi phương thức getDetails của lớp Student
        return super.getDetails() + ", Đề tài nghiên cứu: " + researchTopic + ", Giảng viên: " + supervisorName;
    }
}

class StudentManagement {
    public static void main(String[] args) {
        try {
            Student[] students = new Student[4];

            students[0] = new Student("Nguyễn Văn A", "SV001", 8.5);
            students[1] = new Student("Trần Thị B", "SV002", 7.8);

            students[2] = new GraduateStudent("Lê Văn K", "SV003", 9.2, "Ứng dụng AI trong Y", "TS. Nguyễn Văn G");
            students[3] = new GraduateStudent("Hoàng Thị L", "SV004", 8.9, "Nghiên cứu phát triển ứng dụng AI", "PGS. Lê Thị B");

            System.out.println("DANH SÁCH SINH VIÊN:");

            for (int i = 0; i < students.length; i++) {
                System.out.println((i + 1) + ". " + students[i].getDetails());
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
}