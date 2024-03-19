package com.fi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fi.product.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {
	@Query("Select c from Category c where c.status = 'DANG_SU_DUNG'")
    List<Category> findALLByEnabled();
}
