package io.github.rafaestefogo.domain.entity;

public class ItemOrderEntity {
    private Integer id;
    private OrderEntity orderEntity;
    private ProductEntity productEntity;
    private int quantity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public OrderEntity getOrders() {
        return orderEntity;
    }

    public void setOrders(OrderEntity orderEntity) {
        this.orderEntity = orderEntity;
    }

    public ProductEntity getProduct() {
        return productEntity;
    }

    public void setProduct(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
