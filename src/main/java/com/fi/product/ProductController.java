package com.fi.product;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fi.reqres.ResponseObject;
import com.fi.reqres.product.CreateProdutDetailRequest;
import com.fi.reqres.product.FindProductDetailRequest;
import com.fi.servie.impl.ProductDetailImpl;
import com.fi.servie.product.ProductDetailService;

@RestController
//@CrossOrigin("*")
@RequestMapping("/user/product")
public class ProductController {
	@Autowired
	private ProductDetailService productService;
	
	
	
	@GetMapping("/")
    public ResponseEntity<List<ProductDetail>> getAllProduct(){
        List<ProductDetail> list = productService.getAllProduct();
        return ResponseEntity.ok(list);
    }
	
	@GetMapping("/{id}")
    public ResponseEntity<ProductDetail> getProduct(@PathVariable String id){
		ProductDetail product = productService.getProduct(id);
        return ResponseEntity.ok(product);
    }
	
	@PostMapping("/add")
	public ResponseEntity<ProductDetail> createProduct(@RequestBody CreateProdutDetailRequest req){
		ProductDetail productDetail = productService.createProduct(req);
		return ResponseEntity.ok(productDetail);
	}
}
