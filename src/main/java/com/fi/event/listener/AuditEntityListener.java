package com.fi.event.listener;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import com.fi.entity.AuditEntity;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

public class AuditEntityListener {
	private static final String idAccount = "d69164ec-11b8-11ee-be56-0242ac120002";

    @PrePersist
    private void onCreate(AuditEntity entity) {
        entity.setCreatedDate(getCurrentTime());
        entity.setLastModifiedDate(getCurrentTime());
        entity.setCreatedBy(idAccount);
        entity.setUpdatedBy(idAccount);
    }

    @PreUpdate
    private void onUpdate(AuditEntity entity) {
        entity.setLastModifiedDate(getCurrentTime());
    }

    private long getCurrentTime() {
        ZoneId vietnamZone = ZoneId.of("Asia/Ho_Chi_Minh");
        ZonedDateTime currentTimeInVietnam = Instant.now().atZone(vietnamZone);
        return currentTimeInVietnam.toInstant().toEpochMilli();
    }
}
