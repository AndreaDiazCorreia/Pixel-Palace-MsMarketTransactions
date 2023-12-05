package com.pixelpalace.msMarketTransactions.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {

    private Long userID;
    private String username;

    private String password;
}
