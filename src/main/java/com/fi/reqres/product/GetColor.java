package com.fi.reqres.product;

import org.springframework.beans.factory.annotation.Value;

public interface GetColor {
	@Value("#{target.code}")
    String getCode();
    @Value("#{target.name}")
    String getName();
}
