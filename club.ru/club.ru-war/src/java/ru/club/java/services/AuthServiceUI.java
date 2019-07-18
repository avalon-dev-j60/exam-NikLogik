/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.club.java.services;

import ru.club.java.dto.UserDTO;
import javax.ejb.*;
import javax.inject.Inject;
import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import ru.club.java.exceptions.RequiredDataExceprion;

/**
 *
 * @author nikitorches
 */
@Stateless
public class AuthServiceUI {
    
    @EJB UserServiceRemote userRemote;
    
    @Inject HttpSession session;
    
    public void signIn(String login, String password) throws AuthenticationException{
        
        UserDTO user = userRemote.find(login);
        
        if(user==null){
            throw new AuthenticationException("User with this login does not exist");
        }
        if(!userRemote.verification(login, password)){
            throw new AuthenticationException("Password does not match");
        }
        session.setAttribute("user", user.getLogin());
        
    }
    
    public void signOut(){
        session.invalidate();
    }
    
    public boolean isSignedIn(String login){
        return session.getAttribute("user") != null;
    }
    
    public void register(String name, String lastName, String login, String password, 
                                      String confPassword, String email, String phone) 
                                                   throws AuthenticationException, RequiredDataExceprion{
        if (userRemote.find(login)!=null){
            throw new AuthenticationException("User with this login has already exist");
        }
        if (!confPassword.equals(password)) {
            throw new RequiredDataExceprion("Password does not match");
        }
        userRemote.create(new UserDTO(name, lastName, login, password, email, phone));
    }
    
    public String getUser(){
        String login = (String) session.getAttribute("user");
        return login;
    }
    
}
