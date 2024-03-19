package com.fi.servie.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.fi.entity.Status;
import com.fi.exception.ProductExitsEx;
import com.fi.product.Product;
import com.fi.repository.ProductRepository;
import com.fi.reqres.CreateProductReq;
import com.fi.reqres.product.FindProductDetailRequest;
import com.fi.reqres.product.FindProductRequest;
import com.fi.reqres.product.ProductDetailResponse;
import com.fi.reqres.product.ProductResponse;
import com.fi.reqres.product.ProductUseRespone;
import com.fi.reqres.product.UpdateProductRequest;
import com.fi.servie.product.ProductService;

import jakarta.validation.Valid;

@Service
@Validated
public class ProductImpl implements ProductService {

	@Override
	public List<ProductResponse> findAll(FindProductRequest req) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> fillAllByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product create(@Valid CreateProductReq req) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product update(@Valid UpdateProductRequest req) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product getOneById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductUseRespone> getProductUse(FindProductRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductDetailResponse> getAllProduct(FindProductDetailRequest req) {
		// TODO Auto-generated method stub
		return null;
	}
	
//	@Autowired
//    private ProductRepository productRepository;
//	
//	@Override
//	public List<ProductResponse> findAll(FindProductRequest req) {
//		// TODO Auto-generated method stub
//		return productRepository.getAll(req);
//	}
//
//	@Override
//	public List<String> fillAllByName(String name) {
//		// TODO Auto-generated method stub
//		return productRepository.findAllByName(name);
//	}
//
//	@Override
//	public Product create(@Valid CreateProductReq req) {
//		// TODO Auto-generated method stub
//		Product pro = productRepository.getOneByCode(req.getCode());
//		if(pro != null) {
//			throw new ProductExitsEx("PRoduct existed");
//		}
//		Product add = new Product();
//        add.setStatus(Status.valueOf(req.getStatus()));
//        add.setName(req.getName());
//        add.setCode(req.getCode());
//		return productRepository.save(add);
//	}
//
//	@Override
//	public Product update(@Valid UpdateProductRequest req) {
//		// TODO Auto-generated method stub
//		Optional<Product> optional = productRepository.findById(req.getId());
//        if (!optional.isPresent()) {
//            throw new ProductExitsEx("Not exists");
//        }
//        Product checkCode = productRepository.getOneByCode(req.getCode());
//        if (checkCode != null) {
//            throw new ProductExitsEx("PRoduct existed");
//        }
//        Product update = optional.get();
//        update.setCode(req.getCode());
//        update.setName(req.getName());
//        update.setStatus(Status.valueOf(req.getStatus()));
//        return productRepository.save(update);
//	}
//
//	@Override
//	public Boolean delete(String id) {
//		// TODO Auto-generated method stub
//		Optional<Product> optional = productRepository.findById(id);
//        if (!optional.isPresent()) {
//            throw new ProductExitsEx("Exits");
//        }
//        productRepository.delete(optional.get());
//        return true;
//	}
//
//	@Override
//	public Product getOneById(String id) {
//		// TODO Auto-generated method stub
//		Optional<Product> optional = productRepository.findById(id);
//        if (!optional.isPresent()) {
//            throw new ProductExitsEx("Exits");
//        }
//        return optional.get();
//	}
//
//	@Override
//	public List<ProductUseRespone> getProductUse(FindProductRequest request) {
//		// TODO Auto-generated method stub
//		return productRepository.getProductUse(request);
//	}
//
//	@Override
//	public List<ProductDetailResponse> getAllProduct(FindProductDetailRequest req) {
//		// TODO Auto-generated method stub
//		return productRepository.getAllProduct(req);
//	}

	

}
