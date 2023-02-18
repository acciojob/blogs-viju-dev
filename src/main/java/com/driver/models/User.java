package com.driver.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;
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
    public User(String username, String password) {
        this.username = username;
        Password = password;
//        this.firstName = "test";
//        this.lastName = "test";
//        blogList = new ArrayList<>();//empty
    }

    public User(Integer id, String username, String password, String firstName, String lastName, List<Blog> blogList) {
        this.id = id;
        this.username = username;
        Password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.blogList = blogList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Blog> getBlogList() {
        return blogList;
    }

    public void setBlogList(List<Blog> blogList) {
        this.blogList = blogList;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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