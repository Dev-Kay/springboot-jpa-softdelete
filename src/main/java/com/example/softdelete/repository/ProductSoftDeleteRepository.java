package com.example.softdelete.repository;

import com.example.softdelete.entity.ProductSoftDeleteEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductSoftDeleteRepository
	extends SoftDeleteRepository<ProductSoftDeleteEntity, Long> {}
