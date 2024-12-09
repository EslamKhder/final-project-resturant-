package springdemo.finalprojectrestoran.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springdemo.finalprojectrestoran.Controller.ProductController;
import springdemo.finalprojectrestoran.Mapper.ProductMapper;
import springdemo.finalprojectrestoran.Repository.ProductRepository;
import springdemo.finalprojectrestoran.Service.ProductService;
import springdemo.finalprojectrestoran.dto.ProductDto;
import springdemo.finalprojectrestoran.model.Product;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;




    @Override
    public List<ProductDto> getProductsByCategoryId(Long categoryId) {
        return ProductMapper.PRODUCT_MAPPER.toDtoList(productRepository.findAllByCategoryId(categoryId));
    }

    @Override
    public List<ProductDto> getProductByName(String productName) {
        List<Product> product = productRepository.findByName(productName);
         if(product.isEmpty()) {
             throw  new RuntimeException("error.product");
         }
        return ProductMapper.PRODUCT_MAPPER.toDtoList(product);
    }

    @Override
    public List<ProductDto> getProductByLetters(String letter) {

        List<Product> products = productRepository.getProductByLetters(letter);

        if (products.isEmpty()) {
            throw  new RuntimeException("error.noSuchLetter");
        }
        return ProductMapper.PRODUCT_MAPPER.toDtoList(products);
    }


}
