package com.shiv.Controller;

import java.util.List;

import com.shiv.Model.User;
import com.shiv.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user")
    public ResponseEntity<List<User>> listAllUser(){
        List<User> list = userService.listAllUser();

        if(list.size() == 0){
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<List<User>>(list, HttpStatus.OK);
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<User> findbyId(@PathVariable(name="id") int id){

        User userById = userService.findUserById(id);



        return new ResponseEntity<>(userById, HttpStatus.OK);
    }

    @RequestMapping(value="/add/", method = RequestMethod.POST, headers="Accept=application/json")
    public ResponseEntity<String> add(@RequestBody User user){
        String s = userService.addUser(user);


        return new ResponseEntity<>(s, HttpStatus.CREATED);
    }

    @RequestMapping(value="/update/{id}", method = RequestMethod.PUT, headers="Accept=application/json")
    public ResponseEntity<String> update(@PathVariable("id") int id, @RequestBody User user){
        user.setId(id);
        String s = userService.updateUser(user);


        return new ResponseEntity<>(s, HttpStatus.OK);
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE, headers="Accept=application/json")
    public ResponseEntity<String> delete(@PathVariable("id") int id, @RequestBody User user){
        user.setId(id);
        String delete = userService.delete(user);


        return new ResponseEntity<>(delete, HttpStatus.NO_CONTENT);
    }
}