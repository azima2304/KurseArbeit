package com.example.cinema.base;



import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PROTECTED)
@MappedSuperclass

public class BaseEntity {
    protected Date createdDate;
    protected Date updateDate;

    @PrePersist
    protected void onCreate(){
        this.createdDate = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updateDate = new Date();
    }

}
