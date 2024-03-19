package com.fi.repository;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fi.product.ProductDetail;
import com.fi.product.Size;

@Repository
public interface SizeRepository extends JpaRepository<Size, String> {


}
