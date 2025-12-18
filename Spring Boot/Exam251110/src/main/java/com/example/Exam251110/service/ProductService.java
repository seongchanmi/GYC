package com.example.Exam251110.service;

import com.example.Exam251110.dto.ProductDto;
import com.example.Exam251110.entity.ProductEntity;
import com.example.Exam251110.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repo;

    // 등록
    @Transactional
    public ProductEntity register(ProductDto dto) {
        ProductEntity productEntity = ProductEntity.builder()
                .name(dto.getName())
                .price(dto.getPrice())
                .build();
        return repo.save(productEntity);
    }

    // 전체 조회
    public List<ProductEntity> findAll() {
        return repo.findAll();
    }

    // 개별 조회
    public ProductEntity findById(int id) {
        return repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "번호 잘못 입력"));
    }

    // 수정
    @Transactional
    public ProductEntity updateDetail(int id, ProductDto dto) {
        ProductEntity productEntity = repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "번호 잘못 입력"));

        if (dto.getName() == null || dto.getName().isBlank()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "할 일은 필수입니다.");
        }
        productEntity.updateName(dto.getName());
        productEntity.updatePrice(dto.getPrice());
        return productEntity;
    }

    // 삭제
    @Transactional
    public void delete(int id) {
        ProductEntity productEntity = repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "번호 잘못 입력"));
        repo.deleteById(id);
    }

}
