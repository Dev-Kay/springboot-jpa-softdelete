package com.example.softdelete.repository;

import com.example.softdelete.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository
	extends JpaRepository<ProductEntity, Long> {}
