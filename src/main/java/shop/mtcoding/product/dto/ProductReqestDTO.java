package shop.mtcoding.product.dto;

import lombok.*;

public class ProductReqestDTO {

    @Getter @Setter @NoArgsConstructor @AllArgsConstructor
    public static class ProductSaveReqDTO {
        private String name;
        private Integer price;
        private Integer qty;
    }

    @Getter @Setter @NoArgsConstructor @AllArgsConstructor
    public static class ProductUpdateReqDTO {
        private Integer id;
        private String name;
        private Integer price;
        private Integer qty;
    }
}
