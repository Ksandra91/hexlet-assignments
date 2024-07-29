package exercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

import exercise.repository.ProductRepository;
import exercise.dto.ProductDTO;
import exercise.dto.ProductCreateDTO;
import exercise.dto.ProductUpdateDTO;
import exercise.exception.ResourceNotFoundException;
import exercise.mapper.ProductMapper;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper mapper;

    // BEGIN
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductDTO> index() {
        var result = productRepository.findAll()
                .stream()
                .map(product -> mapper.map(product)).toList();
        return result;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDTO create(@RequestBody ProductCreateDTO data) {
        var product = mapper.map(data);
        productRepository.save(product);
        var productDTO = mapper.map(product);
        return productDTO;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductDTO show(@PathVariable Long id) {
        var product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not Found: " + id));
        var productDTO = mapper.map(product);
        return productDTO;

    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductDTO update(@RequestBody ProductUpdateDTO data, @PathVariable Long id) {
        var product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not Found"));
        mapper.update(data, product);
        productRepository.save(product);
        var productDTO = mapper.map(product);
        return productDTO;
    }
    // END
}
