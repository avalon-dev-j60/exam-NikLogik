/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.club.java.services;

import java.util.List;
import javax.ejb.Remote;
import ru.club.java.dto.PostDTO;

/**
 *
 * @author nikitorches
 */
@Remote
public interface PostServiceRemote {
    
    public void create(PostDTO pDto);
    
    public void update(PostDTO pDto);
    
    public void delete(PostDTO pDto);
    
    public List<PostDTO> findByAuthor(String login);
    
    public PostDTO find(long id);
    
    public List<PostDTO> findAll();
}
