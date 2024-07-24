package exercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

import exercise.model.Product;
import exercise.repository.ProductRepository;
import exercise.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductRepository productRepository;

    private final Sort sort = Sort.by(Sort.Order.asc("price"));

    // BEGIN
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Product> index(@RequestParam(defaultValue = "") Integer min, @RequestParam(defaultValue = "") Integer max) {
        if (min == null && max == null) {
            return productRepository.findAll(sort);
        } else if (min == null) {
            return productRepository.findByPriceLessThanEqual(max, sort);
        } else if (max == null) {
            return productRepository.findByPriceGreaterThanEqual(min, sort);
        } else
            return productRepository.findByPriceBetween(min, max, sort);
    }
    // END

    @GetMapping(path = "/{id}")
    public Product show(@PathVariable long id) {

        var product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product with id " + id + " not found"));

        return product;
    }
}
