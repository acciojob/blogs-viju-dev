package com.driver.services;

import com.driver.models.Blog;
import com.driver.models.Image;
import com.driver.models.User;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.ImageRepository;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BlogService {
    @Autowired
    BlogRepository blogRepository1;

    @Autowired
    ImageService imageService1;

    @Autowired
    UserRepository userRepository1;

    public List<Blog> showBlogs(){
        //find all blogs
        List<Blog> blogList = new ArrayList<>();
        blogList = blogRepository1.findAll(); // getAll blogs
        return blogList;
    }

    public void createAndReturnBlog(Integer userId, String title, String content) throws Exception {
        //create a blog at the current time
        if(userRepository1.findById(userId).isPresent()){
            throw new Exception();
        }
        User user = userRepository1.findById(userId).get();
        Blog blog = new Blog(user,title,content);
        blogRepository1.save(blog); //blog created
        user.getBlogList().add(blog);
        return;

        //updating the blog details

        //Updating the userInformation and changing its blogs

    }

    public Blog findBlogById(int blogId){
        //find a blog
        return blogRepository1.getOne(blogId);
    }

    public void addImage(Integer blogId, String description, String dimensions){
        //add an image to the blog after creating it
        imageService1.addImage(blogId,description,dimensions);
        return;
    }

    public void deleteBlog(int blogId){
        //delete blog and corresponding images
        blogRepository1.deleteById(blogId);
        return;
    }
}
