package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService {
    @Autowired
    ImageRepository imageRepository2;
    @Autowired
    BlogRepository blogRepository2;
    public Image addImage(int blogId, String description, String dimensions){
        //create an image based on given parameters and add it to the imageList of given blog

        Blog blog = blogRepository2.findById(blogId).get();
        Image image = new Image(blog,description,dimensions);
        blog.getImageList().add(image);
        blogRepository2.save(blog); //cascading effect will save image too
//        imageRepository2.save(image);


//        Image image =imageRepository2.save(new Image(blogRepository.getOne(blogId),description,dimensions)); // giving null pointer exceptions
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

        Image image = imageRepository2.findById(id).get();  //.getOne(id) gives error
        String imgDimension = image.getDimensions();
        String[] imgDimensions = imgDimension.split("X");
        int imgDim1 = Integer.valueOf(imgDimensions[0]);
        int imgDim2 = Integer.valueOf(imgDimensions[1]);

        int horizontal = dim1/imgDim1;
        int vertical = dim2/imgDim2;
        count = horizontal * vertical;

        return count;
    }
}
