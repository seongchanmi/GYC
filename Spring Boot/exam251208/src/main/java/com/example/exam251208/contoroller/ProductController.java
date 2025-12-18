package com.example.exam251208.contoroller;

import com.example.exam251208.dto.ProductRequest;
import com.example.exam251208.dto.ProductResponse;
import com.example.exam251208.entity.Product;
import com.example.exam251208.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class ProductController {

    private final ProductService productService;

    // 등록
    @PostMapping("/products")
    public ResponseEntity<ProductResponse> regist(@RequestBody ProductRequest request) {
        Product saved = productService.registProduct(request);
        return ResponseEntity.ok(ProductResponse.fromEntity(saved));
    }

    // 전체 조회
    @GetMapping("/products")
    public ResponseEntity<List<ProductResponse>> getProductS() {
        List<ProductResponse> list = productService.findAll().stream()
                .map(product -> ProductResponse.fromEntity(product))
                .toList();
        return ResponseEntity.ok(list);
    }

    // 삭제
    @DeleteMapping("/products/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

}



