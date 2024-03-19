package com.fi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fi.product.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, String> {
	
}
