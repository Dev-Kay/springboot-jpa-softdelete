package com.example.softdelete.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

@MappedSuperclass
@Setter
@Getter
public class SoftDeleteEntity {
    protected static final String SOFT_DELETED_CLAUSE = "deleted = false";

    @Column(name = "deleted")
    @Builder.Default
    protected Boolean isDeleted = false;

}
