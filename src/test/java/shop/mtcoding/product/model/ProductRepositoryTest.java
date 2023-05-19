package shop.mtcoding.product.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@MybatisTest
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    ObjectMapper om = new ObjectMapper();
    @Test
    public void findByUsernameAndPassword_test() throws Exception {
        // given

        // when
        List<Product> productListPS = productRepository.findAll();

        // verify
        assertThat(productListPS.size()).isEqualTo(2);
        assertThat(productListPS.get(0).getId()).isEqualTo(1);
        assertThat(productListPS.get(0).getName()).isEqualTo("바나나");
        
    }
}
