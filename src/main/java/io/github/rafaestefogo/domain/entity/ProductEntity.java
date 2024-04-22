package io.github.rafaestefogo.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "productValue")
    private BigDecimal value;

    @Column(name = "description")
    private String description;

    @Column(name = "availableStock")
    private Integer availableStock;

    public ProductEntity(String name, BigDecimal value, String description, Integer availableStock) {
        this.name = name;
        this.value = value;
        this.description = description;
        this.availableStock = availableStock;
    }

    public ProductEntity() {}

    @Override
    public String toString() {
        return "Product -> " +
                "\nId = " + id +
                "\nName = " + name +
                "\nValue = " + value +
                "\nDescription = " + description +
                "\nAvailableStock = " + availableStock;
    }
}
