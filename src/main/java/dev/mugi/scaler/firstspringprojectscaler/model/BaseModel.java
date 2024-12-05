package dev.mugi.scaler.firstspringprojectscaler.model;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class BaseModel {
    @Id
    private Long id;
    private Date createdAt;
    private Date updatedAt;
    private Boolean isDeleted;
}