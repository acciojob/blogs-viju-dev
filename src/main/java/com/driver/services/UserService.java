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

    public User createUser(String username,String password){
         User user = new User(username,password);
         userRepository3.save(user);
         return user;
    }

    public void deleteUser(int userId){
        userRepository3.deleteById(userId);
        return;
    }

    public User updateUser(int id,String password){
        User user = userRepository3.findById(id).get();
       user.setPassword(password);
       userRepository3.save(user);
       return user;

    }

//    public User findUserByUsername(String username){
//        return userRepository3.findByUsername(username); // we just added this method in repo but not implemented
//    }

}
