package Bai8;

class InvalidPhoneNumberException extends Exception {
    private String phoneNumber;

    public InvalidPhoneNumberException(String phoneNumber, String message) {
        super(message);
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
