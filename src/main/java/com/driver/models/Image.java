package com.driver.models;

import javax.persistence.*;

@Entity
@Table(name = "image")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String description;
    private String dimension;

//    public Image(Integer imgId, String description, String dimension) {
//        ImgId = imgId;
//        Description = description;
//        Dimension = dimension;
//    }

    //map
    @ManyToOne
    @JoinColumn
    private Blog blog; // here we mention where we ave to join for many to one  // or child case // in chils class

    public  Image(){

    }
    public Image(Blog blog, String description, String dimensions) {
        this.description = description;
        this.dimension = dimensions;
        this.blog = blog;
    }
    public Image(int id,String description, String dimension) {
        this.id = id;
        this.description = description;
        this.dimension = dimension;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }
}