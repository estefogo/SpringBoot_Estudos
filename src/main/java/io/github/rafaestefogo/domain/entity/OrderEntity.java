package io.github.rafaestefogo.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @ManyToOne //um cliente pode ter muitos pedidos, mas um pedido so pode pertencer a um cliente
    @JoinColumn(name = "client")
    private ClientEntity client;

    @OneToMany(mappedBy = "clientOrder")
    private List<ItemOrderEntity> itemOrder;

    @Column(name = "date")
    private LocalDate orderDate;
    @Column(name = "total", precision = 20, scale = 2) //o precision indica quantos digitos o numero pode ter e o lenght quantas casas decimais
    private BigDecimal totalValue;

    public OrderEntity(ClientEntity client, LocalDate orderDate, BigDecimal totalValue) {
        this.client = client;
        this.orderDate = orderDate;
        this.totalValue = totalValue;
    }

    public OrderEntity() {
    }

    public List<ItemOrderEntity> getItemOrder() {
        return itemOrder;
    }

    public void setItemOrder(List<ItemOrderEntity> itemOrder) {
        this.itemOrder = itemOrder;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ClientEntity getClient() {
        return client;
    }

    public void setClient(ClientEntity clientEntity) {
        this.client = clientEntity;
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

    @Override
    public String toString() {
        return "Order" +
                "{Id:" + id +
                ", orderDate:" + orderDate +
                ", totalValue:" + totalValue +
                '}';
    }
}
