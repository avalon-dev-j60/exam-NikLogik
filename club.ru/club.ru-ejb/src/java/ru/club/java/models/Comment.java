/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.club.java.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author nikitorches
 */
@Entity(name = "Comments")
public class Comment implements Serializable{

    @Id
    @GeneratedValue
    private long id;
    
    @Column(nullable = false)
    private String content;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fr_user_comment", referencedColumnName = "id")
    private User author;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fr_post_comment", referencedColumnName = "id")
    private Post post;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    
    public Comment() {}

    public Comment(String content, User author, Post post) {
        this.content = content;
        this.author = author;
        this.post = post;
        this.created = new Date();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public long getId() {
        return id;
    }

    public Date getCreated() {
        return created;
    }
    
}
