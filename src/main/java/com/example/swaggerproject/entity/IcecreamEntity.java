package com.example.swaggerproject.entity;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Entity
@Table(name = "ICECREAM")
public class IcecreamEntity {
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "NAME", length = 50, nullable = false, unique = false)
    private String name;
    @Column(name = "FLAVOUR", length = 50, nullable = false, unique = false)
    private String flavour;
    @Column(name = "PRICE", length = 50, nullable = false, unique = false)

    private Float price;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlavour() {
        return flavour;
    }

    public void setFlavour(String flavour) {
        this.flavour = flavour;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
