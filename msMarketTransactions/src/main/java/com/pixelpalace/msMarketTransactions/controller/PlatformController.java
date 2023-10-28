package com.pixelpalace.msMarketTransactions.controller;

import com.pixelpalace.msMarketTransactions.service.IPlatformService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/platform")
public class PlatformController {

    private final IPlatformService platformService;

    public PlatformController(IPlatformService platformService) {
        this.platformService = platformService;
    }
}
