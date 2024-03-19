package com.fi.event.listener;

import java.util.UUID;

import com.fi.entity.PrimaryEntity;

import jakarta.persistence.PrePersist;

public class CreateEntityListener {
	
	@PrePersist
    private void onCreate(PrimaryEntity entity) {
        entity.setId(UUID.randomUUID().toString());
    }
}
