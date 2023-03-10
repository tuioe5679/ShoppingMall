package ci.jvision.admin.domain.products;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductsRepository extends JpaRepository<Products, Long> {
    @Query("select p from Products p order by p.id DESC")
    List<Products> findAllDesc();
}
