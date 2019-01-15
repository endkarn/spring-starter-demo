package com.example.demo.service.customer;

import com.example.demo.common.ErpRequest;
import com.example.demo.common.ErpResponse;

public interface CustomerService {
    ErpResponse findCustomerById(String id) throws Exception;

    ErpResponse searchCustomer(ErpRequest erpRequest) throws Exception;

    ErpResponse insertCustomer(ErpRequest erpRequest) throws Exception;

    ErpResponse updateCustomer(ErpRequest erpRequest) throws Exception;
}
