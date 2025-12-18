package com.example.Exam251110.controller;

import com.example.Exam251110.dto.ProductDto;
import com.example.Exam251110.entity.ProductEntity;
import com.example.Exam251110.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    // 등록
    @PostMapping
    public ResponseEntity<ProductDto> create(@RequestBody ProductDto dto){
        ProductEntity saved = service.register(dto);
        return ResponseEntity.ok(ProductDto.fromEntity(saved));
    }

    // 전체 조회
    @GetMapping
    public ResponseEntity<List<ProductDto>> getProducts(){
        List<ProductDto> list = service.findAll()
                .stream()
                .map(productEntity -> ProductDto.fromEntity(productEntity))
                .toList();
        return ResponseEntity.ok(list);

    }

    // 개별 조회
    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> prodctFindById(@PathVariable int id){
        ProductEntity productEntity = service.findById(id);
        return ResponseEntity.ok(ProductDto.fromEntity(productEntity));
    }

    // 수정
    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable int id, @RequestBody ProductDto dto){
        ProductEntity updated = service.updateDetail(id, dto);
        return ResponseEntity.ok(ProductDto.fromEntity(updated));
    }

    // 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}