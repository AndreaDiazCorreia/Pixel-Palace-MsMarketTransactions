package com.pixelpalace.msMarketTransactions.repository;

import com.pixelpalace.msMarketTransactions.model.PixelUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PixelUserRepository extends JpaRepository<PixelUser, Long> {

    PixelUser findByUsername(String username);
    PixelUser findByEmail(String email);


}
