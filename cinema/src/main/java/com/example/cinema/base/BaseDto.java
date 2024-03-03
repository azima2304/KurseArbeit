package com.example.cinema.base;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.MappedSuperclass;
import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PROTECTED)
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class BaseDto {
    protected Date createdDate;
    protected Date updateDate;
    protected boolean status;
}