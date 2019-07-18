/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.club.java.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 * 
 * @author nikitorches
 */

@Entity(name = "Users")
@NamedQuery(name = "findUserByLogin", 
            query = "SELECT user FROM Users AS user WHERE user.login=:login")
public class User implements Serializable  {
    
    @Id
    @GeneratedValue
    private long id;
    
    private String name;
    
    private String lastName;
    
    
    @Column(nullable = false, unique = true)
    private String login;
    
    @Column(nullable = false)
    private String password;
    
    private String email;
    
    private String phone;
    
    @OneToMany(cascade = CascadeType.ALL,
                mappedBy = "author",
                targetEntity = Post.class)
    private List<Post> posts;
    
    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "author",
            targetEntity = Comment.class)
    private List<Comment> comments;
    
    public User() {
    }

    public User(String name, String lastName, String login, String password, String email, String phone) {
        this.name = name;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLogin() {
        return login;
    }
    
    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
    
    public void addPost(Post post){ 
        this.posts.add(post);
        post.setAuthor(this);
    }
    
    public void removePost(Post post){
        this.posts.remove(post);
        post.setAuthor(null);
    }
    
    public List<Post> getPosts() {
        return posts;
    }
    
    public List<Comment> getComments() {
        return comments;
    }

    
}
