package com.fi.servie.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.fi.product.Brand;
import com.fi.repository.BrandRepository;
import com.fi.servie.product.BrandService;

@Service
public class BrandImpl implements BrandService {
	@Autowired
	private BrandRepository brandRepository;
	
	
	public List<Brand> getAll() {
		// TODO Auto-generated method stub
		List<Brand> brand = brandRepository.findAll(Sort.by("id").descending());
		return brand;
	}
	
}
