package io.github.rafaestefogo.domain.entity.jdbc;

import java.math.BigDecimal;
import java.time.LocalDate;

public class OrderEntityJdbc {
    private Integer id;
    private ClientEntityJdbc clientEntity;
    private LocalDate orderDate;
    private BigDecimal totalValue;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ClientEntityJdbc getClient() {
        return clientEntity;
    }

    public void setClient(ClientEntityJdbc clientEntity) {
        this.clientEntity = clientEntity;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(BigDecimal totalValue) {
        this.totalValue = totalValue;
    }
}
