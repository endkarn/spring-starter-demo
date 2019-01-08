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
        domainDto.setId(00001l);
        domainDto.setFirstname("Naphatsanan");
        domainDto.setLastname("Boonchom");
        return domainDto;
    }
}

