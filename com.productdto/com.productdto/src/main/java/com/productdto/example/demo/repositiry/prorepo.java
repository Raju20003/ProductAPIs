package com.productdto.example.demo.repositiry;

import com.productdto.example.demo.entity.product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface prorepo extends JpaRepository<product,Integer> {
}
