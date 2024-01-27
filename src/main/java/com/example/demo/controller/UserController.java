package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

   @GetMapping("/{id}")
    public ResponseEntity getUserById(@PathVariable("id") Long id){
       User resUser=userService.getUserById(id);
       System.out.println(resUser);
       if (resUser!=null)
       return new ResponseEntity<>(resUser,HttpStatus.OK) ;
       else {
           ResponseEntity not_found = new ResponseEntity<>("Not found", HttpStatus.NOT_FOUND);
           return not_found;
       }
   }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User resUser=userService.createUser(user);
      return new ResponseEntity<>(resUser,HttpStatus.OK);
    }

}
