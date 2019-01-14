package com.example.demo.dto;

import java.util.List;

public class CustomerDto extends ErpBaseDto{

    private Long id;
    private String customerCode;
    private String firstname;
    private String lastname;
    private String nickname;
    private String gender;
    private String mobile;
    private String email;
    private OrganizationDataDto organization;
    private List<WelcomeDrinkDto> topWelcomeDrinkList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public OrganizationDataDto getOrganization() {
        return organization;
    }

    public void setOrganization(OrganizationDataDto organization) {
        this.organization = organization;
    }

    public List<WelcomeDrinkDto> getTopWelcomeDrinkList() {
        return topWelcomeDrinkList;
    }

    public void setTopWelcomeDrinkList(List<WelcomeDrinkDto> topWelcomeDrinkList) {
        this.topWelcomeDrinkList = topWelcomeDrinkList;
    }
}
