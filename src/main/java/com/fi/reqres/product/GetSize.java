package com.fi.reqres.product;

import org.springframework.beans.factory.annotation.Value;

public interface GetSize {
	@Value("#{target.id}")
    String getId();
    @Value("#{target.name}")
    String getName();
}
