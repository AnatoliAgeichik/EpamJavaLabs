package by.epam.eventto.restService;


import by.epam.eventto.entity.User;
import by.epam.eventto.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id){
        userService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUser( @PathVariable String id){
        return ResponseEntity.ok(userService.getEntity(id).get());
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUser(){
        return ResponseEntity.ok(userService.getData());
    }


    @PutMapping("/user")
    public ResponseEntity<Void> updateUser( @ModelAttribute User user){
        userService.update(user);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/user")
    public ResponseEntity<Void> createUser(@ModelAttribute  User user ){
        userService.create(user);
        return ResponseEntity.ok().build();
    }








}
