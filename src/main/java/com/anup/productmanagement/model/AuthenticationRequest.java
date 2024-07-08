package com.anup.productmanagement.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AuthenticationRequest {
    @NotBlank(message = "emailId can't be empty or null")
    @Email(message = "emailId is not valid")
    private String emailId;
    @NotBlank(message = "password can't be empty or null")
    @Size(min = 8, message = "password length should be minimum 8 characters")
    private String password;
}
