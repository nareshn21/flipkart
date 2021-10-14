package com.naresh.flipkart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.naresh.flipkart.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	

}
