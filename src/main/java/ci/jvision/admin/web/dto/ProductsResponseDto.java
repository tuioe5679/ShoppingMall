package ci.jvision.admin.web.dto;

import ci.jvision.admin.domain.products.Products;
import lombok.Getter;

@Getter
public class ProductsResponseDto {

    private Long p_id;
    private String p_name;
    private int p_price;
    private String p_desc;

    public ProductsResponseDto(Products products) {
        this.p_id = products.getP_id();
        this.p_name = products.getP_name();
        this.p_price = products.getP_price();
        this.p_desc = products.getP_desc();
    }
}
