package com.example.demo.dto;

public class OrganizationDataDto extends ErpBaseDto {
    private Long id;
    private String organizationNameTH;
    private String organizationNameEN;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrganizationNameTH() {
        return organizationNameTH;
    }

    public void setOrganizationNameTH(String organizationNameTH) {
        this.organizationNameTH = organizationNameTH;
    }

    public String getOrganizationNameEN() {
        return organizationNameEN;
    }

    public void setOrganizationNameEN(String organizationNameEN) {
        this.organizationNameEN = organizationNameEN;
    }
}
