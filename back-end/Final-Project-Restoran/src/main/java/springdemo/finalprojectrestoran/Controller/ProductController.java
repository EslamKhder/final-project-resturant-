package springdemo.finalprojectrestoran.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springdemo.finalprojectrestoran.Service.CategoryService;
import springdemo.finalprojectrestoran.Service.ProductService;
import springdemo.finalprojectrestoran.dto.CategoryDto;
import springdemo.finalprojectrestoran.dto.ProductDto;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;


    @GetMapping("/getProductsBy/{id}")
    ResponseEntity<List<ProductDto>> productByCategoryId(@PathVariable("id") Long CategoryId) {
        return ResponseEntity.ok(productService.getProductsByCategoryId(CategoryId));
    }
    @GetMapping("/getProductsByName/{productName}")
    ResponseEntity<List<ProductDto>> productByCategoryId(@PathVariable("productName") String name) {
        return ResponseEntity.ok(productService.getProductByName(name));
    }

    @GetMapping("/getProductsByletter/{letters}")
    ResponseEntity<List<ProductDto>> productByLetters(@PathVariable("letters") String Letter) {
        return ResponseEntity.ok(productService.getProductByLetters(Letter));
    }
}
