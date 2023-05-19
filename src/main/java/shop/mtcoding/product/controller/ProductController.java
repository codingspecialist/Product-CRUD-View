package shop.mtcoding.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {

    @GetMapping({"/product", "/"})
    public String list() {
        return "productList";
    }
}
