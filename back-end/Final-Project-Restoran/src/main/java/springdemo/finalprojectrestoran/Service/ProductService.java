package springdemo.finalprojectrestoran.Service;

import springdemo.finalprojectrestoran.dto.ProductDto;
import springdemo.finalprojectrestoran.model.Product;

import java.util.List;

public interface ProductService {
    List<ProductDto> getProductsByCategoryId(Long categoryId);
    //ProductDto getProductById(Long id);

    List<ProductDto> getProductByName(String productName);
    List<ProductDto> getProductByLetters(String letter);

}
