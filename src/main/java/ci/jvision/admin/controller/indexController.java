package ci.jvision.admin.ShoppingMall.controller;

import ci.jvision.admin.ShoppingMall.service.ProductsService;
import ci.jvision.admin.ShoppingMall.web.dto.ProductsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class indexController {

    private final ProductsService productsService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("product", productsService.findAllDesc());
        return "layout/index";
    }

    @GetMapping("/products/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/products/update/{id}")
    public String postUpdate(@PathVariable Long id, Model model) {
        ProductsResponseDto dto = productsService.findById(id);
        model.addAttribute("products", dto);
        return "posts-update";
    }
}
