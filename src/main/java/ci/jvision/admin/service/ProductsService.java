package ci.jvision.admin.ShoppingMall.service;

import ci.jvision.admin.ShoppingMall.domain.products.Products;
import ci.jvision.admin.ShoppingMall.domain.products.ProductsRepository;
import ci.jvision.admin.ShoppingMall.web.dto.ProductsListResponseDto;
import ci.jvision.admin.ShoppingMall.web.dto.ProductsResponseDto;
import ci.jvision.admin.ShoppingMall.web.dto.ProductsSaveRequestDto;
import ci.jvision.admin.ShoppingMall.web.dto.ProductsUpdateResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductsService {

    private final ProductsRepository productsRepository;

    @Transactional
    public List<ProductsListResponseDto> findAllDesc(){
        return productsRepository.findAllDesc().stream()
                .map(ProductsListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional// 트랜잭션을 보장 하는 어노테이션 (commit 또는 rollback 수행)
    public Long update(Long id, ProductsUpdateResponseDto dto){
        Products products = productsRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다 id="+id));
        products.update(dto.getP_name(),dto.getP_price(), dto.getP_desc());
        System.out.println(dto.getP_desc());
        return id;
    }

    @Transactional
    public Long save(ProductsSaveRequestDto dto){
        Products products = dto.toEntity();
        return productsRepository.save(products).getP_id();
    }

    @Transactional
    public ProductsResponseDto findById(Long id){
        Products products = productsRepository.findById(id).get();
        return new ProductsResponseDto(products);
    }

    @Transactional// 트랜잭션을 보장 하는 어노테이션 (commit 또는 rollback 수행)
    public void productDelete(Long id){
        System.out.println(id);
        Products products = productsRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        productsRepository.delete(products);
    }
}
