package com.example.exam251208.dto;

import com.example.exam251208.entity.Product;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductRequest {

    @NotBlank(message = "상품명 필수 입력")
    private String name;

    @NotBlank(message = "가격 필수 입력")
    private Integer price;

    public Product toEntity() {
        return Product.builder()
                .name(name)
                .price(price)
                .build();
    }

}
