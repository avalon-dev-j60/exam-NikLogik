/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.club.java.services;

import java.util.*;
import javax.ejb.Stateless;
import javax.persistence.*;
import ru.club.java.dto.PostDTO;
import ru.club.java.exceptions.ValidationException;
import ru.club.java.helpers.ValidationHelper;
import ru.club.java.models.Post;
import ru.club.java.models.User;

/**
 *
 * @author nikitorches
 */
@Stateless
public class PostService implements PostServiceRemote{

    UserService userService;
    
    @PersistenceContext(unitName = "UsersPU")
    EntityManager em;
    
    @Override
    public void create(PostDTO pDto) {
        String login = pDto.getAuthor();
        User user = (User) em.createNamedQuery("findUserByLogin").setParameter("login", login).getSingleResult();
        try {
            ValidationHelper.requireNonNull(user, "User with this login does not exist");
            user.addPost(new Post(user, pDto.getTitle(), pDto.getContent()));
        } catch (ValidationException ex) {
            ex.getMessage();
        }
    }
    
    @Override
    public void update(PostDTO pDto) {
        long lId = pDto.getId();
        Post post = em.createNamedQuery("find-post-by-id", Post.class).setParameter("id", lId).getSingleResult();
        post.setContent(pDto.getContent());
        post.setTitle(pDto.getTitle());
        em.merge(post);
        em.flush();
    }

    @Override
    public void delete(PostDTO pDto) {
        String author = pDto.getAuthor();
        long lId = pDto.getId();
        Post post = em.createNamedQuery("find-post-by-id", Post.class).setParameter("id", lId).getSingleResult();
        User user = (User) em.createNamedQuery("findUserByLogin").setParameter("login", author).getSingleResult();
        user.removePost(post);
        em.remove(post);
    }

    @Override
    public List<PostDTO> findByAuthor(String login) {
        User user = (User) em.createNamedQuery("findUserByLogin").setParameter("login", login).getSingleResult();
        try{
        List<Post> posts = em.createNamedQuery("find-post-by-author", Post.class).setParameter("author", user).getResultList();
        List<PostDTO> postsDto = new ArrayList<>();
        posts.forEach((p) -> {
            postsDto.add(p.getInstance());
            });
        return postsDto;
        } catch (NoResultException e){
            return Collections.emptyList();
        }
    }

    @Override
    public PostDTO find(long id) {
        try {
        Post post = (Post) em.createNamedQuery("find-post-by-id", Post.class).setParameter("id", id).getSingleResult();
        return post.getInstance();
        } catch (NoResultException e){
            return null;
        }
    }

    @Override
    public List<PostDTO> findAll() {
        try{
        List<Post> posts = em.createNamedQuery("find-post-all", Post.class).getResultList();
        List<PostDTO> postsDto = new ArrayList<>();
        posts.forEach((p) -> {
            postsDto.add(p.getInstance());
            });
        return postsDto;
        } catch (NoResultException e){
            return Collections.emptyList();
        }
    }
}
