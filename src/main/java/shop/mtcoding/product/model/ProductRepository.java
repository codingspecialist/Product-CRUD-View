package shop.mtcoding.product.model;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductRepository {

    List<Product> findAll();

    Product findById(int id);

}
