import java.util.*;

class Contact {
    private static int idCounter = 1;
    private int id;
    private String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.id = idCounter++;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Contact contact = (Contact) obj;
        return phoneNumber.equals(contact.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneNumber);
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Phone: " + phoneNumber;
    }
}

class ContactManager {
    private Set<Contact> contacts = new HashSet<>();

    public void addContact(String name, String phoneNumber) {
        Contact newContact = new Contact(name, phoneNumber);
        if (!contacts.add(newContact)) {
            System.out.println("Số điện thoại đã tồn tại");
        } else {
            System.out.println("Liên lạc dc thêm thành công");
        }
    }

    public void removeContact(String phoneNumber) {
        contacts.removeIf(contact -> contact.getPhoneNumber().equals(phoneNumber));
        System.out.println("Liên hệ đã bị xóa");
    }

    public void searchContact(String phoneNumber) {
        for (Contact contact : contacts) {
            if (contact.getPhoneNumber().equals(phoneNumber)) {
                System.out.println("Lỗi: " + contact);
                return;
            }
        }
        System.out.println("Không tìm thấy liên hệ");
    }

    public void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("Không có địa chỉ liên hệ nào");
        } else {
            contacts.forEach(System.out::println);
        }
    }
}
 class Bai10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContactManager manager = new ContactManager();
        int choice;

        do {
            System.out.println("\n1. Thêm liên hệ");
            System.out.println("2. Xóa liên hệ");
            System.out.println("3. Tìm kiê liên hệ");
            System.out.println("4. Hiển thị liên hệ");
            System.out.println("5. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Nhập tên: ");
                    String name = scanner.nextLine();
                    System.out.print("Nhập số điện thoại: ");
                    String phone = scanner.nextLine();
                    manager.addContact(name, phone);
                    break;
                case 2:
                    System.out.print("Nhập sdt để xóa: ");
                    phone = scanner.nextLine();
                    manager.removeContact(phone);
                    break;
                case 3:
                    System.out.print("Nhập sdt để tìm kiếm: ");
                    phone = scanner.nextLine();
                    manager.searchContact(phone);
                    break;
                case 4:
                    manager.displayContacts();
                    break;
                case 5:
                    System.out.println("Thoát chương trình");
                    break;
                default:
                    System.out.println("Lựa chọn k hợp lệ");
            }
        } while (choice != 5);
        scanner.close();
    }
}
