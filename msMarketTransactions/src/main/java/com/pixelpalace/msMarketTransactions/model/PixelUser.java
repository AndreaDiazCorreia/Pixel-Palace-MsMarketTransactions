package com.pixelpalace.msMarketTransactions.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pixelpalace.msMarketTransactions.dto.PixelUserDto;
import com.pixelpalace.msMarketTransactions.util.Rol;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.List;

@Data
@Entity
@Table(name = "User")
public class PixelUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String lastname;

    private String username;
    private String password;
    private String email;
    //private List<Productos>; //queda pendiente este atributo

    @Enumerated(EnumType.STRING)
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


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "transactions_idUser",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "transacctions_id"))
    private List<Transaction> transactions;

    public PixelUser(PixelUserDto pixelUserDto) {
        this.id = pixelUserDto.getId();
        this.name = pixelUserDto.getName();
        this.lastname = pixelUserDto.getLastname();
        this.birthday = pixelUserDto.getBirthday();
        this.username = pixelUserDto.getUsername();
        this.email = pixelUserDto.getEmail();
        this.password = pixelUserDto.getPassword();

    }



    public PixelUser() {

    }

    public PixelUser(Long id) {
        this.id = id;
    }
}
