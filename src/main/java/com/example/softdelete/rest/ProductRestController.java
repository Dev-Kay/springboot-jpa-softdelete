package com.example.softdelete.rest;

import com.example.softdelete.entity.ProductEntity;
import com.example.softdelete.entity.ProductSoftDeleteEntity;
import com.example.softdelete.service.ProductService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductRestController {
    private final ProductService productService;

    @GetMapping
    public List<ProductSoftDeleteEntity> getAll() {
        return productService.getProducts();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productService.deleteById(id);
    }

    @PatchMapping("/{id}/restore")
    public void restore(@PathVariable Long id) {
        productService.restoreById(id);
    }

    @PatchMapping("/{id}/restore2")
    public void restore2(@PathVariable Long id) {
        productService.restoreById2(id);
    }
}
