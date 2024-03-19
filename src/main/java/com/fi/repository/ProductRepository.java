package com.fi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fi.product.Product;
import com.fi.reqres.product.FindProductDetailRequest;
import com.fi.reqres.product.FindProductRequest;
import com.fi.reqres.product.ProductDetailResponse;
import com.fi.reqres.product.ProductResponse;
import com.fi.reqres.product.ProductUseRespone;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

}
