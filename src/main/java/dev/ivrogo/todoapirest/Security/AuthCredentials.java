package dev.ivrogo.todoapirest.Security;

import lombok.Data;

@Data
public class AuthCredentials {
    private String email;
    private String password;
}
