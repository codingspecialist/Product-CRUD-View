package shop.mtcoding.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {

    @GetMapping("/badRequest")
    public String badRequest() {
        return "error/error400";
    }

    @GetMapping("/serverError")
    public String serverError() {
        return "error/error500";
    }
}
