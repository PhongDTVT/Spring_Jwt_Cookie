package com.fi.entity;

import com.fi.event.listener.CreateEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
@EntityListeners(CreateEntityListener.class)
public abstract class PrimaryEntity extends AuditEntity
implements IsIdentified {
	@Id
    @Column(length = 36, updatable = false)
    private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
}
