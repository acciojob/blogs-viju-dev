package com.driver.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer UserId;

    private String UserName;
    private String Password;
    private String firstName;
    private String lastName;

    //map
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    @JoinColumn
    private List<Blog> blogList;

//    public User(String userName, String password, String firstName, String lastName) {

    public User(){

    }
    public User(String userName, String password) {
        UserName = userName;
        Password = password;
        this.firstName = "test";
        this.lastName = "test";
        blogList = new ArrayList<>();//empty
    }

    public Integer getUserId() {
        return UserId;
    }

    public void setUserId(Integer userId) {
        UserId = userId;
    }

    public List<Blog> getBlogList() {
        return blogList;
    }

    public void setBlogList(List<Blog> blogList) {
        this.blogList = blogList;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}