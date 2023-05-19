package shop.mtcoding.product.model;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import shop.mtcoding.product.dto.ProductReqestDTO;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@MybatisTest
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void findAll_test() throws Exception {
        // given

        // when
        List<Product> productListPS = productRepository.findAll();

        // verify
        assertThat(productListPS.size()).isEqualTo(2);
        assertThat(productListPS.get(0).getId()).isEqualTo(1);
        assertThat(productListPS.get(0).getName()).isEqualTo("바나나");
        
    }

    @Test
    public void findById_test() throws Exception {
        // given
        int id = 1;

        // when
        Product productPS = productRepository.findById(id);

        // verify
        assertThat(productPS.getId()).isEqualTo(1);
        assertThat(productPS.getName()).isEqualTo("바나나");
        assertThat(productPS.getPrice()).isEqualTo(3000);

    }

    @Test
    public void insert_test() throws Exception {
        // given
        ProductReqestDTO.ProductSaveReqDTO productSaveReqDTO = new ProductReqestDTO.ProductSaveReqDTO("망고", 1000, 100);
        Product product = new Product(productSaveReqDTO);

        // when
        productRepository.insert(product);

        // verify
        assertThat(product.getId()).isEqualTo(3);
    }

    @Test
    public void updateById_test() throws Exception {
        // given
        ProductReqestDTO.ProductUpdateReqDTO productUpdateReqDTO = new ProductReqestDTO.ProductUpdateReqDTO(1,"망고", 1000, 100);

        // when
        int result = productRepository.updateById(productUpdateReqDTO);

        // verify
        assertThat(result).isEqualTo(1);
    }
}
