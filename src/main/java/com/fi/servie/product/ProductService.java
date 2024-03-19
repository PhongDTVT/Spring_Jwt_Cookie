package com.fi.servie.product;

import java.util.List;

import com.fi.product.Product;
import com.fi.reqres.CreateProductReq;
import com.fi.reqres.product.FindProductDetailRequest;
import com.fi.reqres.product.FindProductRequest;
import com.fi.reqres.product.ProductDetailResponse;
import com.fi.reqres.product.ProductResponse;
import com.fi.reqres.product.ProductUseRespone;
import com.fi.reqres.product.UpdateProductRequest;

import jakarta.validation.Valid;


public interface ProductService {

	List<ProductResponse> findAll(final FindProductRequest req);

    List<String> fillAllByName(String name);

    Product create(@Valid final CreateProductReq req);

    Product update(@Valid final UpdateProductRequest req);

    Boolean delete(String id);

    Product getOneById(String id);

    List<ProductUseRespone> getProductUse(FindProductRequest request);

    List<ProductDetailResponse> getAllProduct(FindProductDetailRequest req);

}
