package com.pixelpalace.msMarketTransactions.controller;

import com.pixelpalace.msMarketTransactions.model.PixelUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetTransacionResponse {
    private Long id;

    private List<PixelUser> pixelUsers =new ArrayList<>() ;
}
