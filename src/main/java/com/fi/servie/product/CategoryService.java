package com.fi.servie.product;

import java.util.List;

import com.fi.product.Category;
import com.fi.reqres.product.CreateCategoryRequest;

public interface CategoryService {
	List<Category> findAll();

    List<Category> getListEnabled();

    Category createCategory(CreateCategoryRequest request);

    Category updateCategory(String id,CreateCategoryRequest request);

    void enableCategory(String id);

    void deleteCategory(String id);
}
