package com.camera42.ticket_service.dto;

import com.camera42.ticket_service.model.User;
import lombok.Data;

@Data
public class RegisterRequest {
    private String email;
    private String password;
    private User.Role role;

}
