package com.fi.reqres.product;

import org.springframework.beans.factory.annotation.Value;

public interface GetBrand {
	@Value("#{target.id}")
    String getId();
    @Value("#{target.name}")
    String getName();
}
