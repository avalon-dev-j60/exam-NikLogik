/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.club.java.services;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import ru.club.java.dto.PostDTO;
import ru.club.java.exceptions.ValidationException;
import ru.club.java.helpers.ValidationHelper;

/**
 *
 * @author nikitorches
 */
@Stateless
public class PostServiseUI {
    
    @EJB PostServiceRemote postService;
    
    @Inject HttpSession session;
    
    public void createNewPost(String title, String context) throws IllegalArgumentException{
        if (title==null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title can not be empty");
        }
        if (context==null || context.trim().isEmpty()) {
            throw new IllegalArgumentException("Discription of your post can not be empty");
        }
        String login = (String) session.getAttribute("user");
        if(login == null || login.trim().isEmpty()){
            throw new IllegalArgumentException("Discription of your post can not be empty");
        }
        PostDTO post = new PostDTO(title, context, login);
        postService.create(post);
    }
    
    public void delete(PostDTO dto){
        try {
            ValidationHelper.requireNonNull(dto, "Post does not exist");
            postService.delete(dto);
        } catch (ValidationException ex) {
            ex.getMessage();
        }
    }
    
    public void update(PostDTO dto) {
        try {
            ValidationHelper.requireNonNull(dto, "Post does not exist");
            postService.update(dto);
        } catch (ValidationException ex) {
            ex.getMessage();
        }
        
    }
    
    public PostDTO find(long id){
        try {
            ValidationHelper.requireNonNull(id, "Post does not exist");
            return postService.find(id);
        } catch (ValidationException ex) {
            return null;
        }
    }
    
    public List<PostDTO>findByAuthor(String login) throws ValidationException{
        ValidationHelper.requireNonNull(login, "User with this login does not exist");
        return postService.findByAuthor(login);
    }
}
