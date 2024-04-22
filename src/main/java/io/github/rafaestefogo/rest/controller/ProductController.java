package io.github.rafaestefogo.rest.controller;

import io.github.rafaestefogo.domain.entity.ProductEntity;
import io.github.rafaestefogo.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/listProducts")
    public List<ProductEntity> listAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("findProductById/{id}")
    public ProductEntity findProductById(@PathVariable("id") Integer id) {
        return productRepository.findById(id) //aqui nao precisa do map pq nao precisa manipular o objeto encontrado
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));
    }

    @PostMapping("/saveNewProduct")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductEntity saveNewProduct(@RequestBody ProductEntity product) { //nao esquecer do @RequestBody
        return productRepository.save(product);
    }

    @DeleteMapping("/deleteProduct/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ProductEntity deleteProductById(@PathVariable("id") Integer id) {
        return productRepository.findById(id)
                .map(product -> {
                    productRepository.delete(product);
                    return product;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));

    }

    @PutMapping("/updateProduct/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ProductEntity updateProduct(@PathVariable Integer id, @RequestBody ProductEntity updatedProduct) {
        return productRepository.findById(id)
                .map(existingProduct -> {
                    updatedProduct.setId(existingProduct.getId());
                    productRepository.save(updatedProduct);
                    return updatedProduct;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));
    }

}
