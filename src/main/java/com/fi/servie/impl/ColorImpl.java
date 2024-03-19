package com.fi.servie.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.fi.product.Color;
import com.fi.repository.ColorRepository;
import com.fi.servie.product.ColorService;

@Service
public class ColorImpl implements ColorService {
	@Autowired
	private ColorRepository colorRepository;
	@Override
	public List<Color> getAll() {
		// TODO Auto-generated method stub
		List<Color> color = colorRepository.findAll(Sort.by("id").descending());
		return color;
	}

}
