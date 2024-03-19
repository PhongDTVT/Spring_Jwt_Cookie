package com.fi.servie.product;

import java.util.List;

import com.fi.product.ProductDetail;
import com.fi.reqres.product.CreateProdutDetailRequest;

public interface ProductDetailService {
	List<ProductDetail> getAllProduct();

    List<ProductDetail> getListNewst(int number);

    List<ProductDetail> getListByPrice();

    List<ProductDetail> findRelatedProduct(long id);

    List<ProductDetail> getListProductByCategory(long id);

    List<ProductDetail> getListByPriceRange(long id,int min, int max);

    List<ProductDetail> searchProduct(String keyword);

    ProductDetail getProduct(String id);

    ProductDetail createProduct(CreateProdutDetailRequest request);

    ProductDetail updateProduct(long id, CreateProdutDetailRequest request);

    void deleteProduct(long id);
}
