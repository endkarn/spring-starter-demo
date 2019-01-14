package com.example.demo.service.customer;

import com.example.demo.common.ApplicationConstant;
import com.example.demo.common.ErpRequest;
import com.example.demo.common.ErpResponse;
import com.example.demo.common.utils.ConnectionService;
import com.example.demo.dto.CustomerDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.util.List;

@Service
public class CustomerServiceImpl extends ConnectionService implements CustomerService{

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public ErpResponse findCustomerById(String id) throws Exception {
        ErpResponse erpResponse = new ErpResponse();
        Connection conn = null;
        try {
            conn = openConnection(conn);
            CustomerDto customerDto = customerRepository.findCustomerById(conn,Long.valueOf(id));
            if(customerDto != null){
                erpResponse.setMessage(ApplicationConstant.SUCCESS);
                erpResponse.setObject(customerDto);
            }else {
                erpResponse.setMessage(ApplicationConstant.FAIL);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection(conn);
        }
        return erpResponse;
    }

    @Override
    public ErpResponse searchCustomer(ErpRequest erpRequest) throws Exception {
        ErpResponse erpResponse = new ErpResponse();
        Connection conn = null;
        Object criteria = (erpRequest.getCriteria() != null ? erpRequest.getCriteria() : null);

        try {
            conn = openConnection(conn);
            List<CustomerDto> customerDtoList = customerRepository.searchCustomer(conn,criteria);
            if(customerDtoList != null && customerDtoList.size() > 0){
                erpResponse.setMessage(ApplicationConstant.SUCCESS);
                erpResponse.setObject(customerDtoList);
            }else {
                erpResponse.setMessage(ApplicationConstant.FAIL);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            closeConnection(conn);
        }
        return erpResponse;
    }

    @Override
    public ErpResponse insertCustomer(ErpRequest erpRequest) throws Exception {
        ErpResponse erpResponse = new ErpResponse();
        Connection conn = null;
        Long insertedId = 0L;
        try {
            conn = openConnection(conn);
            CustomerDto customerDto = new ObjectMapper().convertValue(erpRequest.getBody() , CustomerDto.class);
            insertedId = customerRepository.insertCustomer(conn,customerDto);
            if(insertedId > 0){
                conn.commit();
                erpResponse.setMessage(ApplicationConstant.SUCCESS);
                erpResponse.setObject(insertedId);
            }else {
                erpResponse.setMessage(ApplicationConstant.FAIL);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            closeConnection(conn);
        }
        return erpResponse;
    }
}
