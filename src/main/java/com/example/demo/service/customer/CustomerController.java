package com.example.demo.service.customer;


import com.example.demo.common.ErpRequest;
import com.example.demo.common.ErpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    // -------------------------- Find --------------------------------//
    @GetMapping("/{id}")
    public ErpResponse findCustomerById(@PathVariable String id){
        ErpResponse erpResponse = new ErpResponse();
        try {
            erpResponse = customerService.findCustomerById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return erpResponse;
    }

    @PostMapping("/search")
    public ErpResponse searchCustomer(@RequestBody ErpRequest erpRequest){
        ErpResponse erpResponse = new ErpResponse();
        try {
            erpResponse = customerService.searchCustomer(erpRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return erpResponse;
    }

    // -------------------------- Add --------------------------------//
    @PostMapping("/add")
    public ErpResponse insertCustomer(@RequestBody ErpRequest erpRequest){
        ErpResponse erpResponse = new ErpResponse();
        try {
            erpResponse = customerService.insertCustomer(erpRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return erpResponse;
    }
}
