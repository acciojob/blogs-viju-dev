package com.driver.models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "blog")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer BlogId;

    private String Title;
    private String Content;

    @CreationTimestamp
    private Date pubDate;

    //map
    @ManyToOne
    @JoinColumn
    private User user; //  thsi is key by which user is connected to blog in that mappiing

    @OneToMany(mappedBy = "blog",cascade = CascadeType.ALL)
    @JoinColumn
    private List<Image> imageList = new ArrayList<>();

    public List<Image> getImageList() {
        return imageList;
    }

    public void setImageList(List<Image> imageList) {
        this.imageList = imageList;
    }

    public Blog(){
    }
    public Blog(User user,String title, String content) {
        this.user = user;
        Title = title;
        Content = content;
    }

    public Blog(Integer blogId, String title, String content) {
        BlogId = blogId;
        Title = title;
        Content = content;
    }

    public Integer getBlogId() {
        return BlogId;
    }

    public void setBlogId(Integer blogId) {
        BlogId = blogId;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}