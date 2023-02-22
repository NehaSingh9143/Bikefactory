package com.honda.model;

public class BikeModel {

    private String name;

    private String engineCC;

    private Integer milege;

    private String price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEngineCC() {
        return engineCC;
    }

    public void setEngineCC(String engineCC) {
        this.engineCC = engineCC;
    }

    public Integer getMilege() {
        return milege;
    }

    public void setMilege(Integer milege) {
        this.milege = milege;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "BikeModel{" +
                "name='" + name + '\'' +
                ", engineCC='" + engineCC + '\'' +
                ", milege=" + milege +
                ", price='" + price + '\'' +
                '}';
    }
}
