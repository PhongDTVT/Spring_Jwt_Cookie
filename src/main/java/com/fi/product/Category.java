package com.fi.product;

import com.fi.entity.PrimaryEntity;
import com.fi.entity.Status;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "category")
public class Category extends PrimaryEntity {
	private String name;

    @Enumerated(EnumType.STRING)
    private Status status ;

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

	public Category(String name, Status status) {
		super();
		this.name = name;
		this.status = status;
	}

	public Category() {
		super();
	}
    
    
}
