package com.fi.reqres.product;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import com.fi.product.Product;

@Projection(types = Product.class)
public interface ProductResponse {
	@Value("#{target.stt}")
    Integer getSTT();

    @Value("#{target.id}")
    String getId();

    @Value("#{target.nameProduct}")
    String getName();

    @Value("#{target.status}")
    String getStatus();

    @Value("#{target.code}")
    String getCode();

    @Value("#{target.totalQuantity}")
    Integer getTotalQuantity();
}
