package com.example.demo.repository;

import com.example.demo.model.Comment_Form;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Comment_FormRepository extends JpaRepository<Comment_Form, Long> {
    // Here, you can define custom query methods if needed
}