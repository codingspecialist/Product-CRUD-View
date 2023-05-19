package shop.mtcoding.product.dto;

import lombok.*;

public class ProductReqestDTO {

    @Getter @Setter @NoArgsConstructor @AllArgsConstructor
    public static class ProductSaveReqDTO {
        private String name;
        private Integer price;
        private Integer qty;
    }
}
