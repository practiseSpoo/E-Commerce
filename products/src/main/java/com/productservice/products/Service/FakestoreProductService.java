package com.productservice.products.Service;


import com.productservice.products.Exceptions.ProductNotPresentException;
import com.productservice.products.dtos.ProductResponseDtoFS;
import com.productservice.products.models.Category;
import com.productservice.products.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakestoreProductService implements IProductService {

    @Autowired
    RestTemplate restTemplate;

    public Product getSingleProduct(Long id) throws ProductNotPresentException {

        if(id>20 && id<=40){
            throw new ProductNotPresentException();
        }
        if(id>40){
            throw new ArithmeticException();
        }
        ProductResponseDtoFS response= restTemplate.getForObject("https://fakestoreapi.com/products/" + id, ProductResponseDtoFS.class);

        return  getProductFromResponseDto(response);
    }

    @Override
    public List<Product> getAllProducts() {
        ProductResponseDtoFS[] products = restTemplate.getForObject("https://fakestoreapi.com/products/", ProductResponseDtoFS[].class);

        List<Product> output = new ArrayList<>();
        for (ProductResponseDtoFS productResponseDto : products) {
            output.add(getProductFromResponseDto(productResponseDto));
        }
        return output;
    }


    private Product getProductFromResponseDto(ProductResponseDtoFS response) {

        Product product = new Product();
        product.setId(response.getId());
        product.setName(response.getTitle());
        product.setPrice(response.getPrice());
        product.setDescription(response.getDescription());
        product.setCategory(new Category());
        product.getCategory().setName(response.getCategory());
        product.setImage((response.getImage()));

        return product;
    }

}
