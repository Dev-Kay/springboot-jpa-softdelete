package com.example.softdelete.service;

import com.example.softdelete.entity.ProductEntity;
import com.example.softdelete.entity.ProductSoftDeleteEntity;
import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ProductServiceTest {

    @Autowired
    ProductService productService;

    List<ProductSoftDeleteEntity> givenData;

    @BeforeAll
    void setUp() {
        givenData = productService.saveAll(
            List.of(
                ProductSoftDeleteEntity.builder()
                    .name("콜라")
                    .description("시원한 콜라")
                    .price(BigDecimal.valueOf(1000))
                    .build(),
                ProductSoftDeleteEntity.builder()
                    .name("사이다")
                    .description("뜨끈~~~~한 사이다")
                    .price(BigDecimal.valueOf(2000))
                    .build(),
                ProductSoftDeleteEntity.builder()
                    .name("스프라이트")
                    .description("맛있는거 옆에 스프라잇!!")
                    .price(BigDecimal.valueOf(1200))
                    .build(),
                ProductSoftDeleteEntity.builder()
                    .name("신라면")
                    .description("푸라면~~~")
                    .price(BigDecimal.valueOf(1500))
                    .build(),
                ProductSoftDeleteEntity.builder()
                    .name("조니워커 블루")
                    .description("맛있는 조니워커 블루 라벨")
                    .price(BigDecimal.valueOf(300000))
                    .build(),
                ProductSoftDeleteEntity.builder()
                    .name("포카칩")
                    .description("제일 맛나는 포카칩~~~~")
                    .price(BigDecimal.valueOf(1500))
                    .build()
            )
        );
    }

    @Test
    void printAll() {
        System.out.println("==== BEFORE DELETE ====");
        System.out.println(productService.getProducts());

        ProductSoftDeleteEntity deleteEntity = givenData.get(0);
        System.out.println("==== DELETE PRODUCT ====");
        System.out.println(deleteEntity);
        productService.deleteById(deleteEntity.getId());

        System.out.println("==== AFTER DELETE ====");
        System.out.println(productService.getProducts());

        System.out.println("====== RESTORE PRODUCT ======");
        productService.restoreById(deleteEntity.getId());
        System.out.println(productService.getProducts());

        System.out.println("==== DELETE PRODUCT2 ====");
        productService.deleteById(deleteEntity.getId());
        System.out.println(productService.getProducts());

        System.out.println("====== RESTORE PRODUCT2 ======");
        productService.restoreById2(deleteEntity.getId());
        System.out.println(productService.getProducts());
    }
}