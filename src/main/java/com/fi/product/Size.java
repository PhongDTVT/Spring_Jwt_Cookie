package com.fi.product;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import com.fi.entity.PrimaryEntity;
import com.fi.entity.Status;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "size")
public class Size extends PrimaryEntity {
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


	public Size() {
		super();
	}
	
	
}

