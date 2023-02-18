package com.driver.models;

import javax.persistence.*;

@Entity
@Table(name = "image")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ImgId;

    private String Description;
    private String Dimension;

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
        this.Description = description;
        this.Dimension = dimensions;
        this.blog = blog;
    }
    public Image(int id,String description, String dimension) {
        ImgId = id;
        Description = description;
        Dimension = dimension;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public Integer getImgId() {
        return ImgId;
    }

    public void setImgId(Integer imgId) {
        ImgId = imgId;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getDimension() {
        return Dimension;
    }

    public void setDimension(String dimension) {
        Dimension = dimension;
    }
}