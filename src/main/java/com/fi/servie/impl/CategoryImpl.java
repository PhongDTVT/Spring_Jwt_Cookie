package com.fi.servie.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.fi.entity.Status;
import com.fi.exception.UserAlreadyExistsException;
import com.fi.product.Category;
import com.fi.repository.CategoryRepository;
import com.fi.reqres.product.CreateCategoryRequest;
import com.fi.servie.product.CategoryService;

@Service
public class CategoryImpl implements CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		List<Category> list = categoryRepository.findAll(Sort.by("id").descending());
        return list;
	}

	@Override
	public List<Category> getListEnabled() {
		// TODO Auto-generated method stub
		List<Category> list = categoryRepository.findALLByEnabled();
        return list;
	}

	@Override
	public Category createCategory(CreateCategoryRequest request) {
		// TODO Auto-generated method stub
		Category category = new Category();
        category.setName(request.getName());
        categoryRepository.save(category);
        return category;
	}

	@Override
	public Category updateCategory(String id, CreateCategoryRequest request) {
		// TODO Auto-generated method stub
		Category category = categoryRepository.findById(id).orElseThrow(() -> new UserAlreadyExistsException("Not Found Category With Id: " + id));
        category.setName(request.getName());
        categoryRepository.save(category);
        return category;
	}

	@Override
	public void enableCategory(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCategory(String id) {
		// TODO Auto-generated method stub
		Category category = categoryRepository.findById(id).orElseThrow(() -> new UserAlreadyExistsException("Not Found Category With Id: " + id));
        categoryRepository.delete(category);
	}
	
}
