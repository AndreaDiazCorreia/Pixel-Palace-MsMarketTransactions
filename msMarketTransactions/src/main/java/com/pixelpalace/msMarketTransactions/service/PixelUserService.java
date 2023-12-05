package com.pixelpalace.msMarketTransactions.service;

import com.pixelpalace.msMarketTransactions.dto.LoginDto;
import com.pixelpalace.msMarketTransactions.dto.PixelUserDto;
import com.pixelpalace.msMarketTransactions.dto.response.LoginResponse;
import com.pixelpalace.msMarketTransactions.model.PixelUser;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface PixelUserService {
    String postUser(PixelUserDto pixelUserDto);

    Optional<PixelUser> findOneByUsernameAndPassword(String username, String password);

//   ResponseEntity<Object> deleteUser(long id);

    List<PixelUser> getUser();

    ResponseEntity<Object> deleteUser(long id);

    PixelUser findById(long id);

    PixelUser findByUsername(String username);
    PixelUser findByEmail(String email);

    PixelUser update(Long id, PixelUser user) throws ChangeSetPersister.NotFoundException;

    LoginResponse Login_user (LoginDto loginDto);
}
