package com.example.demo.service.customer;

import com.example.demo.dto.CustomerDto;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface CustomerRepository {
    CustomerDto findCustomerById(Connection conn, Long customerId) throws SQLException;

    List<CustomerDto> searchCustomer(Connection conn, Object criteria) throws SQLException;

    Long insertCustomer(Connection conn, CustomerDto customerDto);
}
