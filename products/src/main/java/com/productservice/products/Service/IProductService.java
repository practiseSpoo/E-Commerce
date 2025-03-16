package com.productservice.products.Service;


import com.productservice.products.Exceptions.ProductNotPresentException;
import com.productservice.products.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProductService {


     Product getSingleProduct(Long id) throws ProductNotPresentException;

     List<Product> getAllProducts();
}
