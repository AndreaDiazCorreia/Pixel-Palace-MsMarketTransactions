package com.pixelpalace.msMarketTransactions.controller;

import com.pixelpalace.msMarketTransactions.dto.LoginDto;
import com.pixelpalace.msMarketTransactions.dto.PixelUserDto;
import com.pixelpalace.msMarketTransactions.dto.response.LoginResponse;
import com.pixelpalace.msMarketTransactions.model.PixelUser;
import com.pixelpalace.msMarketTransactions.service.PixelUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class PixelUserController {
    @Autowired
    PixelUserService pixelUserService;

    @GetMapping("{id}")
    public ResponseEntity<PixelUser> findUserById(@PathVariable Long id) {
        PixelUser user = pixelUserService.findById(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/list")
    public List<PixelUser> getAllUsers() {
        return pixelUserService.getUser();
    }

    @GetMapping("by_username/{username}")
    public ResponseEntity<PixelUser>findbyUsername(@PathVariable String username){
        PixelUser pixelUser = pixelUserService.findByUsername(username);
        if (pixelUser != null){
            return ResponseEntity.ok(pixelUser);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("by_email/{email}")
    public ResponseEntity<PixelUser>findbyEmail(@PathVariable String email){
        PixelUser pixelUser = pixelUserService.findByEmail(email);
        if (pixelUser != null){
            return ResponseEntity.ok(pixelUser);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping(path = "/save")
    public ResponseEntity<String> saveUser(@RequestBody PixelUserDto pixelUserDto){
        String id = pixelUserService.postUser(pixelUserDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuario creado con ID: " + id);
    }


    @PostMapping(path = "/login")
    public ResponseEntity<?>LoginUsername(@RequestBody LoginDto loginDto){
        LoginResponse loginResponse = pixelUserService.Login_user(loginDto);
        return  ResponseEntity.ok(loginResponse);
    }

    /*
    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody PixelUser pixelUser) throws Exception {
        pixelUserService.postUser(pixelUser);
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuario creado exitosamente");
    }
*/

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable("id") long id){
        try {
            pixelUserService.deleteUser(id);
            return ResponseEntity.status(HttpStatus.OK).body("Usuario eliminado exitosamente");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("No se pudo eliminar al usuario");
        }
    }

    @PutMapping("/{id}")
    public PixelUser update(@PathVariable Long id, @RequestBody PixelUser user) throws ChangeSetPersister.NotFoundException {
        return pixelUserService.update(id, user);
    }


}

