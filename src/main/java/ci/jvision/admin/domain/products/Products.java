package ci.jvision.admin.domain.products;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long p_id;

    @Column(nullable = false)
    private String p_name;

    @Column(nullable = false)
    private int p_price;

    @Column(length = 500,nullable = false)
    private String p_desc;

    @Builder
    public Products(Long p_id, String p_name, int p_price, String p_desc) {
        this.p_id = p_id;
        this.p_name = p_name;
        this.p_price = p_price;
        this.p_desc = p_desc;
    }

    public void update(String p_name, int p_price, String p_desc){
        this.p_name = p_name;
        this.p_price = p_price;
        this.p_desc = p_desc;
    }
}
