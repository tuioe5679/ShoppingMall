package ci.jvision.admin.ShoppingMall.web.dto;

import ci.jvision.admin.ShoppingMall.domain.products.Products;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductsUpdateResponseDto {

    private String p_name;
    private int p_price;
    private String p_desc;

    @Builder
    public ProductsUpdateResponseDto(String p_name, int p_price, String p_desc) {
        this.p_name = p_name;
        this.p_price = p_price;
        this.p_desc = p_desc;
    }
}
