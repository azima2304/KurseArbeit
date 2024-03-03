package com.example.cinema.authorization;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class AuthRequest {
    String username;
    String password;
}
