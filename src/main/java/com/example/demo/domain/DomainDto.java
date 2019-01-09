package com.example.demo.domain;

public class DomainDto {
    private String Name;
    private Long Id;
    private Double weight;
    private Double height;
    private String address;
    private Double sum;
    private String result;

    public String getName() {return Name; }
    public void setName(String name) { Name = name; }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Double BMI(){
        sum = weight / Math.pow((height*0.01),2);
        return sum;

    }

}

