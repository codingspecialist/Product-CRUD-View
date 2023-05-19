package shop.mtcoding.product.model;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
public class Product {
    private Integer id;
    private String name;
    private Integer price;
    private Integer qty;
    private Timestamp createdAt;
}
