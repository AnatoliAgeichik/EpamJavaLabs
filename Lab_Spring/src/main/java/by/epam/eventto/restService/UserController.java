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

    @DeleteMapping("/user")
    public ResponseEntity<Void> deleteUser(@RequestParam User user){
        userService.delete(user);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/users")
    public ResponseEntity<User> getUser(@RequestParam String id){
        return ResponseEntity.ok(userService.getEntity(id));
    }


}
