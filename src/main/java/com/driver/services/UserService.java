package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository3;

    @Autowired
    BlogService blogService3;

    public void createUser(String username,String password){
         userRepository3.save(new User(username,password));
         return;
    }

    public void deleteUser(int userId){
        userRepository3.deleteById(userId);
        return;
    }

    public void updateUser(int id,String password){
        User user = userRepository3.findById(id).get();
       userRepository3.save(user);

    }

    public User findUserByUsername(String username){
        return userRepository3.findByUsername(username); // we just added this method in repo but not implemented
    }

}
