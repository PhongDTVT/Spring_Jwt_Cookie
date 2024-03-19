package com.fi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fi.product.Color;

public interface ColorRepo extends JpaRepository<Color, String> {

}
