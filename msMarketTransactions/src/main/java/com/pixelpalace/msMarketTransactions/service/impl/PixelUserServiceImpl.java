package com.pixelpalace.msMarketTransactions.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pixelpalace.msMarketTransactions.dto.LoginDto;
import com.pixelpalace.msMarketTransactions.dto.PixelUserDto;
import com.pixelpalace.msMarketTransactions.dto.response.LoginResponse;
import com.pixelpalace.msMarketTransactions.model.PixelUser;
import com.pixelpalace.msMarketTransactions.repository.PixelUserRepository;
import com.pixelpalace.msMarketTransactions.service.PixelUserService;
import com.pixelpalace.msMarketTransactions.util.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PixelUserServiceImpl implements PixelUserService {

    @Autowired
    PixelUserRepository pixelUserRepository;
    private List<PixelUser> users = new ArrayList<>();
    @Autowired
    ObjectMapper mapper;
 /*
    public void postUser(PixelUser pixelUser) throws Exception{
       try {
            pixelUserRepository.save(pixelUser);
        } catch (Exception e){
            throw new Exception("No se pudo guardar el usuario", e);
        }


    }

 */

    @Override
    public String postUser(PixelUserDto pixelUserDto) {

        PixelUser exiteEmail = pixelUserRepository.findByEmail(pixelUserDto.getEmail());
        if (exiteEmail != null){
            return "El correo se encuentre registrado";
        }
        PixelUser pixelUser = new PixelUser(pixelUserDto);
        pixelUser.setRol(Rol.USER);

        try {
            //pixelUserRepository.save(pixelUser);
            PixelUser savedUser = pixelUserRepository.save(pixelUser);
            System.out.println(savedUser);
            return pixelUser.getUsername();
        } catch (Exception e) {
            e.printStackTrace(); // o log.error("Error al guardar el usuario", e);
            return "Error al guardar el usuario";
        }
        //  pixelUserRepository.save(pixelUser);


    }



    public ResponseEntity<Object> deleteUser(long id){
        if (!pixelUserRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El usuario con ID " + id + " no se encontró en la base de datos.");
        }

        try {

            pixelUserRepository.deleteById(id);
            return ResponseEntity.ok("El usuario con ID " + id + " ha sido eliminado correctamente.");

        }catch (EmptyResultDataAccessException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("No se pudo eliminar al usuario.");
        }
    }

    @Override
    public PixelUser update(Long id, PixelUser user) throws ChangeSetPersister.NotFoundException {
        PixelUser existingUser = pixelUserRepository.findById(id).orElseThrow(() -> new ChangeSetPersister.NotFoundException());


        existingUser.setName(user.getName());
        existingUser.setLastname(user.getLastname());
        existingUser.setUsername(user.getUsername());
        existingUser.setPassword(user.getPassword());
        existingUser.setEmail(user.getEmail());
        existingUser.setBirthday(user.getBirthday());


        return pixelUserRepository.save(existingUser);
    }

    @Override
    public LoginResponse Login_user(LoginDto loginDto) {
        String msg = "";
        PixelUser pixelUser1 = pixelUserRepository.findByUsername(loginDto.getUsername());

        if (pixelUser1 != null) {
            String password = loginDto.getPassword();
            String storedPassword = pixelUser1.getPassword();


            // Utilizando equals() para comparar las contraseñas en lugar de matches()
            if (storedPassword.equals(password)) {
                Long userId = pixelUser1.getId();

                return new LoginResponse("Login Exitoso", true, userId);
            } else {
                return new LoginResponse("Login Fallido: Password Incorrecta", false, null);
            }
        } else {
            return new LoginResponse("Login Fallido: Usuario no Existe", false, null);
        }
    }

    @Override
    public PixelUser findById(long id) {
        return pixelUserRepository.findById(id).orElse(null);
    }

    @Override
    public PixelUser findByUsername(String username) {
        return pixelUserRepository.findByUsername(username);
    }

    @Override
    public PixelUser findByEmail(String email) {
        return pixelUserRepository.findByEmail(email);
    }
    @Override
    public Optional<PixelUser> findOneByUsernameAndPassword(String username, String password) {
        for (PixelUser user : users) {
            if (user.getUsername().equals(username) && user.getPassword().matches(password)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<PixelUser> getUser() {
        return pixelUserRepository.findAll();
    }
}


/*
    public ResponseEntity<Object> deleteUser(long id){
        if (!pixelUserRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El usuario con ID " + id + " no se encontró en la base de datos.");
        }

            try {

            pixelUserRepository.deleteById(id);
            return ResponseEntity.ok("El usuario con ID " + id + " ha sido eliminado correctamente.");

            }catch (EmptyResultDataAccessException e){
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("No se pudo eliminar al usuario.");
        }
    }

 */


