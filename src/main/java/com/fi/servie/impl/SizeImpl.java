package com.fi.servie.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.fi.product.Size;
import com.fi.repository.SizeRepository;
import com.fi.servie.product.SizeService;

@Service
public class SizeImpl implements SizeService {
	@Autowired
	private SizeRepository sizeRepository;
	
	@Override
	public List<Size> getAll() {
		// TODO Auto-generated method stub
		List<Size> size = sizeRepository.findAll(Sort.by("id").descending());
		return size;
	}

}
