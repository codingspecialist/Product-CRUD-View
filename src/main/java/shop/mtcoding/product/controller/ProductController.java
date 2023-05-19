package shop.mtcoding.product.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import shop.mtcoding.product.dto.ProductReqestDTO;
import shop.mtcoding.product.model.Product;
import shop.mtcoding.product.model.ProductRepository;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductRepository productRepository;

    @GetMapping({"/product", "/"})
    public String list(Model model) {
        List<Product> productList = productRepository.findAll();
        model.addAttribute(productList);
        return "product/list";
    }

    @GetMapping("/product/{id}")
    public String detail(@PathVariable int id, Model model) {
        Product product = productRepository.findById(id);
        model.addAttribute(product);
        return "product/detail";
    }

    @GetMapping("/product/saveForm")
    public String saveForm() {
        return "product/saveForm";
    }

    @GetMapping("/product/{id}/updateForm")
    public String updateForm(@PathVariable int id, Model model) {
        Product product = productRepository.findById(id);
        model.addAttribute(product);
        return "product/updateForm";
    }

    @PostMapping("product/add")
    public String save(ProductReqestDTO.ProductSaveReqDTO productSaveReqDTO) {
        Product product = new Product(productSaveReqDTO);
        productRepository.insert(product);
        return "redirect:/product/"+product.getId();
    }
}
