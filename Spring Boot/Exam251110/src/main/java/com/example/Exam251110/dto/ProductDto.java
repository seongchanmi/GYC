package com.example.Exam251110.dto;

import com.example.Exam251110.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private Integer id;
    private String name;
    private Integer price;

    public static ProductDto fromEntity(ProductEntity productEntity){
        return ProductDto.builder()
                .id(productEntity.getId())
                .name(productEntity.getName())
                .price(productEntity.getPrice())
                .build();
    }

    public ProductEntity toEntity(){
        return ProductEntity.builder()
                .id(this.id)
                .name(this.name)
                .price(this.price)
                .build();
    }

}
