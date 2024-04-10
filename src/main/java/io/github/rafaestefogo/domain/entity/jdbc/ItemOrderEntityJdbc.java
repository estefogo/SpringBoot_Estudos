package io.github.rafaestefogo.domain.entity.jdbc;

public class ItemOrderEntityJdbc {
    private Integer id;
    private OrderEntityJdbc orderEntityJdbc;
    private ProductEntityJdbc productEntityJdbc;
    private int quantity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public OrderEntityJdbc getOrders() {
        return orderEntityJdbc;
    }

    public void setOrders(OrderEntityJdbc orderEntityJdbc) {
        this.orderEntityJdbc = orderEntityJdbc;
    }

    public ProductEntityJdbc getProduct() {
        return productEntityJdbc;
    }

    public void setProduct(ProductEntityJdbc productEntityJdbc) {
        this.productEntityJdbc = productEntityJdbc;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
