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

        Image image =imageRepository2.save(new Image(blog,description,dimensions));
//        List<Image> imageList = blog.getImageList();
//        imageList.add(image);
//        blog.setImageList(imageList);
        return image;
    }

    public void deleteImage(int image){

        imageRepository2.deleteById(image);
        return;
    }

    public Image findById(int id) {
        return imageRepository2.getOne(id);
    }

    public int countImagesInScreen(int id, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
        //In case the image is null, return 0
        int count = 0;
        String[] dimensions = screenDimensions.split("X");
        int dim1 = Integer.valueOf(dimensions[0]);
        int dim2 = Integer.valueOf(dimensions[1]);

        Image image = imageRepository2.getOne(id);
        String imgDimension = image.getDimension();
        String[] imgDimensions = imgDimension.split("X");
        int imgDim1 = Integer.valueOf(imgDimensions[0]);
        int imgDim2 = Integer.valueOf(imgDimensions[1]);

        int horizontal = imgDim1/dim1;
        int vertical = imgDim2/dim2;
        count = horizontal * vertical;
        return count;
    }
}
