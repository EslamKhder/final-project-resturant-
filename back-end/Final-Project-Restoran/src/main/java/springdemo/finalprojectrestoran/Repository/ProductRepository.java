package springdemo.finalprojectrestoran.Repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import springdemo.finalprojectrestoran.model.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
List<Product> findAllByCategoryId(Long id);
List<Product> findByName(String name);

@Query(value = "SELECT * FROM Product WHERE name LIKE %:val% OR DESCRIPTION LIKE %:val%", nativeQuery = true)
List<Product> getProductByLetters(@Param("val") String letters);


}
