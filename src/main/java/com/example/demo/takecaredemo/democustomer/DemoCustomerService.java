package com.example.demo.takecaredemo.democustomer;

import com.example.demo.takecaredemo.ErpRequest;
import com.example.demo.takecaredemo.ErpResponse;

public interface DemoCustomerService {
    ErpResponse addCustomer(ErpRequest erpRequest) throws Exception;
}
