package com.honda.entity;

import javax.persistence.*;

@Entity
@Table(name = "bike")
public class Bike {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id" , unique = true)
    private Integer bid;

    private String name;

    private String engineCC;

    private Integer milege;

    private String price;

    public Integer getId() {
        return bid;
    }

    public void setId(Integer id) {
        this.bid = id;
    }

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
        return "Bike{" +
                "id=" + bid +
                ", name='" + name + '\'' +
                ", engineCC='" + engineCC + '\'' +
                ", milege=" + milege +
                ", price='" + price + '\'' +
                '}';
    }
}
