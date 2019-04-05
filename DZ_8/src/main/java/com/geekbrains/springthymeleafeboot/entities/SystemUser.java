package com.geekbrains.springthymeleafeboot.entities;

import com.geekbrains.springthymeleafeboot.validation.FieldMatch;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@FieldMatch(first = "password", second = "matchingPassword", message = "The password in both field should match.")
public class SystemUser {
    @NotNull(message = "Not null check")
    @Size(min = 3, message = "username length should be greater than 2 symbols")
    private String userName;

    @NotNull(message = "Can't be empty")
    @Size(min = 1, message = "Password field can't be empty")
    private String password;

    @NotNull(message = "Can't be empty")
    @Size(min = 1, message = "Matching password field can't be empty")
    private String matchingPassword;

    @NotNull(message = "Can't be empty")
    @Size(min = 1, message = "First name field can't be empty")
    private String firstName;

    @NotNull(message = "Can't be empty")
    @Size(min = 1, message = "Last name field can't be empty")
    private String lastName;

    @NotNull(message = "Can't be empty")
    @Email
    private String email;
}
