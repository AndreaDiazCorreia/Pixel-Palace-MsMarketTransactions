package com.pixelpalace.msMarketTransactions.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pixelpalace.msMarketTransactions.util.Rol;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PixelUserDto {

    private Long id;

    private String name;
    private String lastname;

    private String username;
    private String password;
    private String email;

    private Rol rol;


    @DateTimeFormat(pattern = "dd-mm-yyyy")
    private String birthday;

    @JsonIgnore
    private String existingName;
    @JsonIgnore
    private String existingLastname;
    @JsonIgnore
    private String existingUsername;
    @JsonIgnore
    private String existingPassword;
    @JsonIgnore
    private String existingEmail;
    @JsonIgnore
    private String existingBirthday;
}
