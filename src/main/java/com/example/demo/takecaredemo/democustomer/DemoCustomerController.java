package com.example.demo.takecaredemo.democustomer;

import com.example.demo.takecaredemo.ApplicationConstant;
import com.example.demo.takecaredemo.ErpRequest;
import com.example.demo.takecaredemo.ErpResponse;
import com.example.demo.takecaredemo.HandleMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/democustomer")
public class DemoCustomerController {

    HandleMessage handleMessage = new HandleMessage();
    
    @Autowired
    DemoCustomerService demoCustomerService;
    
    public ResponseEntity<ErpResponse> addCustomer(@RequestBody ErpRequest erpRequest) {
        ResponseEntity<ErpResponse> respEntity = null;
        try {
            
            String userActionID = "111";

            if (!userActionID.equals(0)) {
                ApplicationConstant.PERSON_ID = Long.valueOf(userActionID);
                ErpResponse respEntityResponse = demoCustomerService.addCustomer(erpRequest);
                respEntity = handleMessage.process(1, respEntityResponse);
            } else {
                respEntity = handleMessage.process(2, null);
            }
        } catch (Exception e) {
            respEntity = handleMessage.process(0, null);
        }
        return respEntity;
    }
}
