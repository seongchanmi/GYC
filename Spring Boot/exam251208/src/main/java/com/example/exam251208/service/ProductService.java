package com.example.exam251208.service;

import com.example.exam251208.dto.ProductRequest;
import com.example.exam251208.entity.Product;
import com.example.exam251208.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    // 등록
    @Transactional
    public Product registProduct(ProductRequest request) {
        Product product = Product.builder()
                .name(request.getName())
                .price(request.getPrice())
                .build();
        return productRepository.save(product);
    }

    // 전체 조회
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    // 삭제
    @Transactional
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 글을 찾을 수 없습니다"));
        productRepository.deleteById(id);
    }

}
