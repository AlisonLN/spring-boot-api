package com.example.sbars.controllers;

import com.example.sbars.dtos.ProductRecordDto;
import com.example.sbars.models.ProductModel;
import com.example.sbars.repositores.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@RestController   // ou rescontroler para implementar um api rest
public class ProductController {

    @Autowired  // iniciar o ponto de injeção de productRepository
    ProductRepository productRepository; // é um ponto de injecao para essa interface para que tenhamos acessos ao metodos jpa quando houver necessidade

    @PostMapping("/products")
    public ResponseEntity<ProductModel> saveProduct(@RequestBody @Valid ProductRecordDto productRecordDto)  {
        var productModel = new ProductModel();
        BeanUtils.copyProperties(productRecordDto, productModel); // Conversao de dto para productModel
        return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.save(productModel));
    }
    @GetMapping("/products")
    public ResponseEntity<List<ProductModel>> getAllProducts() {
        return ResponseEntity.status(HttpStatus.OK).body(productRepository.findAll());
    }
    @GetMapping("/products/{id}")
    public ResponseEntity<Object> getOneProduct(@PathVariable(value = "id")UUID id) {
        Optional<ProductModel> productO = productRepository.findById(id);
        if (productO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product NOT FOUND. ");
        }
        return ResponseEntity.status(HttpStatus.OK).body(productO.get());
    }
}
