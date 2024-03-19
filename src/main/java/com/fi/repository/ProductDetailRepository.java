package com.fi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fi.product.ProductDetail;


@Repository
public interface ProductDetailRepository extends JpaRepository<ProductDetail, String> {
	@Query(value = "Select * from Product order by id desc limit :number",nativeQuery = true)
    List<ProductDetail> getListNewest(int number);

    @Query(value = "Select * from Product order by price limit 8 ",nativeQuery = true)
    List<ProductDetail> getListByPrice();

    @Query(value ="Select * from Product where category_id = :id order by rand() limit 4",nativeQuery = true)
    List<ProductDetail> findRelatedProduct(long id);

    @Query(value ="Select * from Product where category_id = :id",nativeQuery = true)
    List<ProductDetail> getListProductByCategory(long id);

    @Query(value = "Select * from Product where category_id = :id and price between :min and :max",nativeQuery = true)
    List<ProductDetail> getListProductByPriceRange(long id,int min,int max);

    @Query(value= "Select p from Product p where p.name like %:keyword% order by id desc")
    List<ProductDetail> searchProduct(String keyword);

}
