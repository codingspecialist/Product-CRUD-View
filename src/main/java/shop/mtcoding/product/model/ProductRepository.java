package shop.mtcoding.product.model;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import shop.mtcoding.product.dto.ProductReqestDTO;

import java.util.List;

@Mapper
public interface ProductRepository {

    List<Product> findAll();

    Product findById(int id);

    int insert(Product product);

    int updateById(ProductReqestDTO.ProductUpdateReqDTO productUpdateReqDTO);
}
