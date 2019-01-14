package com.example.demo.takecaredemo.democustomer;

import com.example.demo.takecaredemo.DemoCustomerDto;
import javafx.scene.control.Pagination;

import java.sql.Connection;
import java.util.List;

public interface DemoCustomerRepository {

    List<DemoCustomerDto> searchCustomer(Connection conn, Object criteria, Pagination pagination, Object orderBy) throws Exception;
    // Insert , Update , Delete
    Long insertCustomer(Connection conn, DemoCustomerDto dto) throws Exception;
    boolean updateCustomer(Connection conn, DemoCustomerDto dto) throws Exception;
    boolean deleteCustomer(Connection conn, DemoCustomerDto dto) throws Exception;
    boolean clearCustomer(Connection conn, DemoCustomerDto dto) throws Exception;
    // Count Item
    int countCustomer(Connection conn, Object criteria) throws Exception;
}
