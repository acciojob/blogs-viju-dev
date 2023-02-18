package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.ImageRepository;
import org.hibernate.sql.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {
    @Autowired
    ImageRepository imageRepository2;

    public Image createAndReturn(Blog blog, String description, String dimensions){
        //create an image based on given parameters and add it to the imageList of given blog

        Image image =imageRepository2.save(new Image(description,dimensions));
        List<Image> imageList = blog.getImageList();
        imageList.add(image);
        blog.setImageList(imageList);
        return image;
    }

    public void deleteImage(Image image){

        imageRepository2.delete(image);
        return;
    }

    public Image findById(int id) {
        return imageRepository2.getOne(id);
    }

    public int countImagesInScreen(Image image, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
        //In case the image is null, return 0
        int count = 0;
        int totalDimension =0;
        String[] dimensions = screenDimensions.split("X");
        totalDimension = Integer.valueOf(dimensions[0]) * Integer.valueOf(dimensions[1]);
        int canFit =0;
        List<Image> imageList = imageRepository2.findAll();
        for (Image image1:imageList){
            String[] imgDim = image1.getDimension().split("X");
            if((Integer.valueOf(imgDim[0] )* Integer.valueOf(imgDim[1])) < totalDimension) {
                totalDimension -= Integer.valueOf(imgDim[0] )* Integer.valueOf(imgDim[1]);
                count++;
            }
            else {
                break;
            }
        }
        return count;
    }
}
