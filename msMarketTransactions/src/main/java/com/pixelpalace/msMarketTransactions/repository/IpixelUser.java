package com.pixelpalace.msMarketTransactions.repository;


import com.pixelpalace.msMarketTransactions.model.PixelUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IpixelUser extends JpaRepository<PixelUser, Long> {
}
