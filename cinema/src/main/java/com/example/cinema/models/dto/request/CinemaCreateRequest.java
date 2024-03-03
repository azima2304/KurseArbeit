package com.example.cinema.models.dto.request;



import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.multipart.MultipartFile;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class CinemaCreateRequest {
    String name;
    MultipartFile logo;
    String description;
    String address;
    String username;
    String password;
}
