package com.sasiperi.demo.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Version;

@MappedSuperclass
public abstract class AbstractTimestampEntity
{

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created", nullable = false)
    private Date created;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated", nullable = false)
    private Date updated;

    @Column(name = "last_updated_by", length = 25)
    private String lastUpdatedBy;

    @PrePersist
    @Version
    protected void onCreate()
    {
        updated = created = new Date();
        lastUpdatedBy = "sasiperi";
    }

    @PreUpdate
    protected void onUpdate()
    {
        updated = new Date();
        lastUpdatedBy = "sasiperi";
    }
}