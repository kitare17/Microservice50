package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity getUserById(@PathVariable("id") Long id) {
        User resUser = userService.getUserById(id);
        System.out.println(resUser);
        if (resUser != null)
            return new ResponseEntity<>(resUser, HttpStatus.OK);
        else {
            ResponseEntity not_found = new ResponseEntity<>("Not found", HttpStatus.NOT_FOUND);
            return not_found;
        }
    }

    @GetMapping
    public ResponseEntity getAllUsers() {
        List<User> userList = userService.getAllUser();
        if (userList.size() > 0)
            return new ResponseEntity(userList, HttpStatus.OK);
        else
            return new ResponseEntity("Empty List", HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User resUser = userService.createUser(user);
        return new ResponseEntity<>(resUser, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        User resUser = userService.updateUser(user, id);
        if (user != null)
            return new ResponseEntity<>(resUser, HttpStatus.OK);
        else
            return new ResponseEntity<>("Not success", HttpStatus.BAD_REQUEST);

    }

}
