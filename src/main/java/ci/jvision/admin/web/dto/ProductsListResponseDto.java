package ci.jvision.admin.ShoppingMall.web.dto;

import ci.jvision.admin.ShoppingMall.domain.products.Products;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductsListResponseDto {

    private Long p_id;
    private String p_name;
    private int p_price;
    private String p_desc;

    @Builder
    public ProductsListResponseDto(Products entity) {
        this.p_id = entity.getP_id();
        this.p_name = entity.getP_name();
        this.p_price = entity.getP_price();
        this.p_desc = entity.getP_desc();
    }

}
