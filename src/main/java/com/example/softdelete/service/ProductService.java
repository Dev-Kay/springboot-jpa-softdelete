package com.example.softdelete.service;

import com.example.softdelete.entity.ProductEntity;
import com.example.softdelete.entity.ProductSoftDeleteEntity;
import com.example.softdelete.repository.ProductRepository;
import com.example.softdelete.repository.ProductSoftDeleteRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductSoftDeleteRepository productSoftDeleteRepository;

    private final ProductRepository productRepository;


    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }

    public List<ProductSoftDeleteEntity> getProducts() {
        return productSoftDeleteRepository.findAll();
    }

    public void restoreById(Long id) {
        ProductEntity productEntity = productRepository.findById(id).orElseThrow();
        productEntity.setIsDeleted(Boolean.FALSE);

        productRepository.save(productEntity);
    }

    public void restoreById2(Long id) {
        ProductSoftDeleteEntity productEntity = productSoftDeleteRepository.findByIdIncludeDeleted(
            id).orElseThrow();
//        productEntity.setIsDeleted(Boolean.FALSE);

        productSoftDeleteRepository.restore(productEntity.getId());
    }

    public void deleteById(Long id) {
        productSoftDeleteRepository.deleteById(id);
    }

    public List<ProductSoftDeleteEntity> saveAll(List<ProductSoftDeleteEntity> inputs) {
        return productSoftDeleteRepository.saveAll(inputs);
    }

    public ProductSoftDeleteEntity save(ProductSoftDeleteEntity input) {
        return productSoftDeleteRepository.save(input);
    }
}
