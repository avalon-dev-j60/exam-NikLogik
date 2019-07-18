/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.club.java.services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author nikitorches
 */
@Stateless
public class CommentService implements CommentServiceRemote{
    
    @PersistenceContext(unitName = "UsersPU")
    EntityManager em;
    
}
