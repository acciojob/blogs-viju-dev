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


    public Image(String description, String dimension) {
        ImgId = getImgId();
        Description = description;
        Dimension = dimension;
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