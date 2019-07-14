/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.club.java.services;

import ru.club.java.dto.UserDTO;
import java.util.HashMap;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import ru.club.java.models.User;

/**
 *
 * @author nikitorches
 */
@Stateless
public class UserService implements UserServiceRemote  {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @PersistenceContext(name = "UsersPU")
    EntityManager em;
    
    @Override
    public void create(UserDTO dto) {
        if (dto!=null) {
            User user = new User(dto.getName(), dto.getLastName(), dto.getLogin(), dto.getPassword(), dto.getEmail(), dto.getPhone());
            em.persist(user);
        }
    }

    @Override
    public void update(UserDTO dto) {
        if (dto!=null) {
            String login = dto.getLogin();
            User user = getUser(login);
            em.merge(user);
        }
    }

    @Override
    public void delete(UserDTO dto) {
        if (dto!=null) {
            String login = dto.getLogin();
            User user = getUser(login);
            em.remove(user);
        }
    }

    @Override
    public UserDTO find(String login) {
       try{
           User user = getUser(login);
           UserDTO dto = new UserDTO(user.getId(), user.getName(), user.getLastName(), user.getLogin(), user.getPassword(), user.getEmail(), user.getPhone());
        return dto;
       }catch (NoResultException e){
           return null;
       }
    }
    
    @Override
    public boolean verification(String login, String password) {
        User user = getUser(login);
        String pass = user.getPassword();
        return pass.equals(password);
    }
    
    public User getUser(String login){
        return (User) em.createNamedQuery("findUserByLogin").setParameter("login", login).getSingleResult();
    }
}
