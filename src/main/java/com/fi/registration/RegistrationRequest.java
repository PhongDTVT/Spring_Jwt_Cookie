package com.fi.registration;

public record RegistrationRequest(
        String firstname,
        String lastname,
        String email,
        String password,
        String role) {
}
