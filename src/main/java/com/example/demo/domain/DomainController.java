package com.example.demo.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/domain")
public class DomainController {

    @Autowired
    DomainService domainService;

    @GetMapping("/hello")
    public DomainDto firstDomainApi(){
        DomainDto domainDto = new DomainDto();
        Double bmi;
        String result;


        domainDto.setName("Naphatsanan Boonchom");
        domainDto.setId(58011212107L);
        domainDto.setAddress("House No.54 Village No.18 Namkham Village " +
                "Namkham Sub-district Thatphanom district Nakhonphanom Province " +
                "Postal Code 48110");
        domainDto.setHeight(165.0);
        domainDto.setWeight(60.2);
        bmi = domainDto.BMI();

        System.out.println(bmi);

        if (bmi<=18.5){
          domainDto.setResult("You thin");
        }
        else if (bmi<=22.9){
            domainDto.setResult("You Good");
        }
        else if (bmi<=24.9){
            domainDto.setResult("You Over weight");
        }
        else if (bmi<=29.9){
            domainDto.setResult ("You Fat");
        }
        else{
            domainDto.setResult("You Vary Fat");
        }
        return domainDto;
    }
}
