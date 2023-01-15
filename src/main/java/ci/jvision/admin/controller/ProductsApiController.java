package ci.jvision.admin.ShoppingMall.controller;

import ci.jvision.admin.ShoppingMall.service.ProductsService;
import ci.jvision.admin.ShoppingMall.web.dto.ProductsListResponseDto;
import ci.jvision.admin.ShoppingMall.web.dto.ProductsResponseDto;
import ci.jvision.admin.ShoppingMall.web.dto.ProductsSaveRequestDto;
import ci.jvision.admin.ShoppingMall.web.dto.ProductsUpdateResponseDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ProductsApiController {

    private final ProductsService productsService;

    @PostMapping("/api/v1/product")
    public Long save(@RequestBody ProductsSaveRequestDto dto){
        return productsService.save(dto);
    }

    @GetMapping("/api/v1/product/{id}")
    public ProductsResponseDto findById(@PathVariable Long id){
        return productsService.findById(id);
    }

    @PutMapping("/api/v1/product/{id}")
    public Long productUpdate(@PathVariable Long id, @RequestBody ProductsUpdateResponseDto dto){
        return productsService.update(id,dto);
    }

    @DeleteMapping("/api/v1/product/{id}")
    public Long productDelete(@PathVariable Long id){
        productsService.productDelete(id);
        return id;
    }
}
