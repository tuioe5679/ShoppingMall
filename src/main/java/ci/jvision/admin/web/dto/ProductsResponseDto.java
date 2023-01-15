package ci.jvision.admin.ShoppingMall.web.dto;

import ci.jvision.admin.ShoppingMall.domain.products.Products;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
