package com.driver.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "blog")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer BlogId;

    private String Title;
    private String Content;
    private List<Image> imageList = new ArrayList<>();

    public List<Image> getImageList() {
        return imageList;
    }

    public void setImageList(List<Image> imageList) {
        this.imageList = imageList;
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
}