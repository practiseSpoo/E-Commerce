package com.productservice.products.controlleradvice;

import com.productservice.products.Exceptions.ProductNotPresentException;
import com.productservice.products.dtos.ProductResponseSelf;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class productControllerAdvice {

    @ExceptionHandler(ProductNotPresentException.class)
    public ResponseEntity<ProductResponseSelf> handleInvalidProduct(){
        ProductResponseSelf productResponseSelf = new ProductResponseSelf(null, "Product doesn't exist from controller advice");
        return new ResponseEntity<>(productResponseSelf , HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ProductResponseSelf> handleArithmeticException(){
        ProductResponseSelf productResponseSelf = new ProductResponseSelf(null, "Something went wrong from controller advice");
        return new ResponseEntity<>(productResponseSelf ,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
