package Bai7.model;

public class Order {
    private int orderId;
    private String customerName;
    private String status;

    public Order() {}

    public Order(int orderId, String customerName, String status) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.status = status;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customerName='" + customerName + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
