/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.club.java.services;

import ru.club.java.dto.UserDTO;
import java.util.HashMap;
import javax.ejb.Remote;


/**
 *
 * @author nikitorches
 */
@Remote
public interface UserServiceRemote {
    
    public UserDTO find(String login);
    
    public boolean verification(String login, String password);
    
    public void create(UserDTO dto);
    
    public void update(UserDTO dto);
    
    public void delete(UserDTO dto);
}
