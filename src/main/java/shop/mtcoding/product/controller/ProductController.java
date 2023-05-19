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
        // 상품 전체 목록 조회
        List<Product> productList = productRepository.findAll();

        // 모델에 저장
        model.addAttribute(productList);

        // 페이지 리턴
        return "product/list";
    }

    @GetMapping("/product/{id}")
    public String detail(@PathVariable int id, Model model) {

        // 해당 상품 조회
        Product product = productRepository.findById(id);

        // 존재하지 않을 경우 에러페이지 리턴
        if (product == null) {
            return "redirect:/badRequest";
        }

        // 모델에 저장
        model.addAttribute(product);

        // 페이지 리턴
        return "product/detail";
    }

    @GetMapping("/product/saveForm")
    public String saveForm() {
        return "product/saveForm";
    }

    @GetMapping("/product/{id}/updateForm")
    public String updateForm(@PathVariable int id, Model model) {

        // 해당 상품 조회
        Product product = productRepository.findById(id);

        // 존재하지 않을 경우 에러페이지 리턴
        if (product == null) {
            return "redirect:/badRequest";
        }

        // 모델에 저장
        model.addAttribute(product);

        // 페이지 리턴
        return "product/updateForm";
    }

    @PostMapping("product/add")
    public String save(ProductReqestDTO.ProductSaveReqDTO productSaveReqDTO) {

        // 저장시 id 값을 받아오기 위해 Product 객체에 저장
        Product product = new Product(productSaveReqDTO);

        // DB 저장
        int result = productRepository.insert(product);

        // 저장 실패할 경우 에러페이지 리턴
        if (result != 1) {
            return "redirect:/serverError";
        }

        // 페이지 리턴
        return "redirect:/product/" + product.getId();
    }

    @PostMapping("/product/{id}/edit")
    public String update(@PathVariable int id ,ProductReqestDTO.ProductUpdateReqDTO productUpdateReqDTO) {

        // 해당 상품 조회
        Product productPS = productRepository.findById(id);

        // 존재하지 않을 경우 에러페이지 리턴
        if (productPS == null) {
            return "redirect:/badRequest";
        }

        // id 값 DTO에 담기 (한번에 전달하기 위해서 사용)
        productUpdateReqDTO.setId(productPS.getId());

        // DB에 해당 ID 상품 업데이트
        int result = productRepository.updateById(productUpdateReqDTO);

        // 업데이트 실패할 경우 에러페이지 리턴
        if (result != 1) {
            return "redirect:/serverError";
        }

        // 페이지 리턴
        return "redirect:/product/" + productUpdateReqDTO.getId();
    }

    @PostMapping("/product/{id}/delete")
    public String delete(@PathVariable int id) {

        // 해당 상품 조회
        Product productPS = productRepository.findById(id);

        // 존재하지 않을 경우 에러페이지 리턴
        if (productPS == null) {
            return "redirect:/badRequest";
        }

        // 해당 ID 상품 삭제
        int result = productRepository.deleteById(productPS.getId());

        // 삭제 실패할 경우 에러페이지 리턴
        if (result != 1) {
            return "redirect:/serverError";
        }

        // 페이지 리턴
        return "redirect:/";
    }
}
