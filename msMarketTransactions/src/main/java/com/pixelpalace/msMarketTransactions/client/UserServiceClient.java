package com.pixelpalace.msMarketTransactions.client;

import com.pixelpalace.msMarketTransactions.model.PixelUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "userManagement-service", url = "http://localhost:8081/")
public interface UserServiceClient {
  //  @GetMapping("/list")
    // List<PixelUser> getAllUsers();

    @GetMapping("/user/{id}")
    PixelUser findUserById(@PathVariable("id") Long id);
}
