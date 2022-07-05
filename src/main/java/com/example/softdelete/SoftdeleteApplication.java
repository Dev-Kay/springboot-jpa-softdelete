package com.example.softdelete;

import com.example.softdelete.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class SoftdeleteApplication implements CommandLineRunner {
    private final ProductService productService;

    public static void main(String[] args) {
        SpringApplication.run(SoftdeleteApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        productService.saveAll(
//            List.of(
//                ProductSoftDeleteEntity.builder()
//                    .name("콜라")
//                    .description("시원한 콜라")
//                    .price(BigDecimal.valueOf(1000))
//                    .build(),
//                ProductSoftDeleteEntity.builder()
//                    .name("사이다")
//                    .description("뜨끈~~~~한 사이다")
//                    .price(BigDecimal.valueOf(2000))
//                    .build(),
//                ProductSoftDeleteEntity.builder()
//                    .name("스프라이트")
//                    .description("맛있는거 옆에 스프라잇!!")
//                    .price(BigDecimal.valueOf(1200))
//                    .build(),
//                ProductSoftDeleteEntity.builder()
//                    .name("신라면")
//                    .description("푸라면~~~")
//                    .price(BigDecimal.valueOf(1500))
//                    .build(),
//                ProductSoftDeleteEntity.builder()
//                    .name("조니워커 블루")
//                    .description("맛있는 조니워커 블루 라벨")
//                    .price(BigDecimal.valueOf(300000))
//                    .build(),
//                ProductSoftDeleteEntity.builder()
//                    .name("포카칩")
//                    .description("제일 맛나는 포카칩~~~~")
//                    .price(BigDecimal.valueOf(1500))
//                    .build()
//            )
//        );
    }
}
