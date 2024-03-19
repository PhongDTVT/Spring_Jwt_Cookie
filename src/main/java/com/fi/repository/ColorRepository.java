package com.fi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fi.product.Color;

@Repository
public interface ColorRepository extends JpaRepository<Color, String> {

}
