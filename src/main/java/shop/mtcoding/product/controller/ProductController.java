package shop.mtcoding.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProductController {

    @GetMapping({"/product", "/"})
    public String list() {
        return "productList";
    }

    @GetMapping("/product/{id}")
    public String detail(@PathVariable int id) {
        return "productDetail";
    }

    @GetMapping("/product/saveForm")
    public String saveForm() {
        return "saveForm";
    }
}
