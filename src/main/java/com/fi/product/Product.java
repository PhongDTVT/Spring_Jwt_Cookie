package com.fi.product;

import com.fi.entity.PrimaryEntity;
import com.fi.entity.Status;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class Product extends PrimaryEntity {
	private String code;

    private String name;

    @Enumerated(EnumType.STRING)
    private Status status;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Product(String code, String name, Status status) {
		super();
		this.code = code;
		this.name = name;
		this.status = status;
	}

	public Product() {
		super();
	}
    
    
}
