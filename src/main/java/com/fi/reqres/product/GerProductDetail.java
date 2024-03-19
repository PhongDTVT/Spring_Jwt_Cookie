package com.fi.reqres.product;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Value;

public interface GerProductDetail {
	@Value("#{target.idProduct}")
    String getIdProduct();
    @Value("#{target.idProductDetail}")
    String getIdProductDetail();

    @Value("#{target.codeColor}")
    String getCodeColor();
    @Value("#{target.nameSize}")
    Integer getNameSize();
    @Value("#{target.image}")
    String getImage();

    @Value("#{target.nameProduct}")
    String getNameProduct();

    @Value("#{target.price}")
    BigDecimal getPrice();
    @Value("#{target.valuePromotion}")
    String getValuePromotion();
    @Value("#{target.createdDate}")
    String getCreatedDate();
}
