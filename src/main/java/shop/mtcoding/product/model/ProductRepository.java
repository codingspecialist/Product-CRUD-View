package shop.mtcoding.product.model;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductRepository {

    List<Product> findAll();

}
