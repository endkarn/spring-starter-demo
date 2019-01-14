package com.example.demo.takecaredemo.democustomer;

import com.example.demo.takecaredemo.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;

@Service
public class DemoCustomerServiceImpl extends ServiceUtil implements DemoCustomerService {

    private static final Logger logger = LoggerFactory.getLogger(DemoCustomerServiceImpl.class);

    @Autowired
    DemoCustomerRepository demoCustomerRepository;

    @Override
    public ErpResponse addCustomer(ErpRequest erpRequest) throws Exception {
        ErpResponse erpResponse = new ErpResponse();
        Connection conn = null;
        Long result = 1L;
        try {
            // GET CONNECTION
            conn = openConnection(conn);

            DemoCustomerDto customer = new ObjectMapper().convertValue(erpRequest.getBody(), DemoCustomerDto.class);
            // ------------ START BUSINESS LOGIC -----------//
            if (customer != null) {
                conn = openConnection(conn);

                result = result > 0 ? demoCustomerRepository.insertCustomer(conn, customer) : 0;

                if (result > 0) {
                    customer.setId(result);

                    commitConnection(conn);

                    ResponseUtils responseUtils = new ResponseUtils(customer.getId());
                    erpResponse.setObject(responseUtils);
                    erpResponse = setMessage(erpResponse, ApplicationConstant.INSERT, ApplicationConstant.SUCCESS);
                    logger.info(String.format("Add Customer : completed {%d}", customer.getId()));
                } else {
                    erpResponse = setMessage(erpResponse, ApplicationConstant.INSERT, ApplicationConstant.FAIL);
                    logger.error("Add Customer : failed");
                }
            }
            // ------------ END BUSINESS LOGIC -----------//
        } catch (Exception ex) {
            ex.printStackTrace();
            erpResponse = setMessage(erpResponse, ApplicationConstant.FIND, ApplicationConstant.FAIL);
            throw new Exception(ex);
        } finally {
            closeConnection(conn);
        }

        return erpResponse;
    }
}
