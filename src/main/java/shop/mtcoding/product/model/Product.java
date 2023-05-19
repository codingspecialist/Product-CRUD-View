package shop.mtcoding.product.model;

import lombok.*;
import shop.mtcoding.product.dto.ProductReqestDTO;

import java.sql.Timestamp;

@Getter
@Setter
public class Product {
    private Integer id;
    private String name;
    private Integer price;
    private Integer qty;
    private Timestamp createdAt;

    public Product(ProductReqestDTO.ProductSaveReqDTO productSaveReqDTO) {
        this.name = productSaveReqDTO.getName();
        this.price = productSaveReqDTO.getPrice();
        this.qty = productSaveReqDTO.getQty();
    }
}
