package com.example.exam251215.repository;

import com.example.exam251215.entity.Todos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodosRepository extends JpaRepository<Todos, Long> {

    Page<Todos> findByTitleContainingIgnoreCaseOrContentContaining(
            String title, String content, Pageable pageable
    );
}
