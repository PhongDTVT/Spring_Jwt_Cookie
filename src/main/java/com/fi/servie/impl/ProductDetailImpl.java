package com.fi.servie.impl;

import java.math.BigDecimal;  
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.fi.exception.UserAlreadyExistsException;
import com.fi.product.Brand;
import com.fi.product.Category;
import com.fi.product.Color;
import com.fi.product.ProductDetail;
import com.fi.product.Size;
import com.fi.repository.BrandRepository;
import com.fi.repository.CategoryRepository;
import com.fi.repository.ColorRepository;
import com.fi.repository.ProductDetailRepository;
import com.fi.repository.ProductRepository;
import com.fi.repository.SizeRepository;
import com.fi.reqres.product.CreateProdutDetailRequest;
import com.fi.reqres.product.FindProductDetailByCategorysConvertRequest;
import com.fi.reqres.product.FindProductDetailRequest;
import com.fi.reqres.product.GetProductDetailOfClient;
import com.fi.reqres.product.ProductDetailResponse;
import com.fi.servie.product.ProductDetailService;

@Service
public class ProductDetailImpl implements ProductDetailService{
	
	@Autowired
	private ProductDetailRepository productRepo;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private BrandRepository brandRepository;
	
	@Autowired
	private ColorRepository colorRepository;
	
	@Autowired
	private SizeRepository sizeRepository;

	@Override
	public List<ProductDetail> getAllProduct() {
		// TODO Auto-generated method stub
		return productRepo.findAll();
	}

	@Override
	public List<ProductDetail> getListNewst(int number) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductDetail> getListByPrice() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductDetail> findRelatedProduct(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductDetail> getListProductByCategory(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductDetail> getListByPriceRange(long id, int min, int max) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductDetail> searchProduct(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductDetail getProduct(String id) {
		// TODO Auto-generated method stub
		ProductDetail product= productRepo.findById(id).orElseThrow(() -> new UserAlreadyExistsException("Not Found Product With Id: " + id));
		return product;
	}

	@Override
	public ProductDetail createProduct(CreateProdutDetailRequest request) {
		// TODO Auto-generated method stub
		ProductDetail product = new ProductDetail();
		
		product.setDescription(request.getDescription());
		product.setQuantity(request.getQuantity());
		product.setName(request.getName());
		
		Brand brand = brandRepository.findById(request.getCategoryId()).orElseThrow(() -> new UserAlreadyExistsException("Not found id category: "+request.getCategoryId()));
		Category category = categoryRepository.findById(request.getCategoryId()).orElseThrow(() -> new UserAlreadyExistsException("Not found id category: "+request.getCategoryId()));
		Color color = colorRepository.findById(request.getColorCode()).orElseThrow(() -> new UserAlreadyExistsException("Not found id category: "+request.getColorCode()));
		
		Set<Size> s = new HashSet<>();
		
		
		Size size = sizeRepository.findById(request.getSizeId()).orElseThrow(() -> new UserAlreadyExistsException("Not found id category: "+request.getSizeId()));
		s.add(size);
		
		

		product.setCategory(category);
		product.setBrand(brand);
		product.setColor(color);
		product.setSize(s);
		
		
		productRepo.save(product);
		return product;
	}

	@Override
	public ProductDetail updateProduct(long id, CreateProdutDetailRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteProduct(long id) {
		// TODO Auto-generated method stub
		
	}
	
	
}
