package Bai8.service;


import Bai7.util.DatabaseUtil;
import Bai8.dao.CustomerDAO;
import Bai8.model.Customer;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CustomerService {
    private final CustomerDAO customerDAO;

    public CustomerService() {
        this.customerDAO = new CustomerDAO();
    }

    public void createCustomersTable() throws SQLException {
        customerDAO.createCustomersTable();
    }

    public void addCustomer(Customer customer) throws SQLException {
        customerDAO.addCustomer(customer);
    }

    public Customer getCustomerById(int customerId) throws SQLException {
        try (Connection connection = DatabaseUtil.getConnection()) {
            return customerDAO.getCustomerById(connection, customerId);
        }
    }

    public List<Customer> getAllCustomers() throws SQLException {
        return customerDAO.getAllCustomers();
    }
}
