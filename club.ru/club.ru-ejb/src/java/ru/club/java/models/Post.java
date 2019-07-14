/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.club.java.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import ru.club.java.dto.PostDTO;

/**
 *
 * @author nikitorches
 */
@Entity(name = "Posts")
@NamedQueries({
    @NamedQuery(name = "find-post-by-author", 
            query = "SELECT post FROM Posts AS post WHERE post.author=:author"),
    @NamedQuery(name = "find-post-all", 
            query = "SELECT post FROM Posts post"),
    @NamedQuery(name = "find-post-by-id", 
            query = "SELECT post FROM Posts AS post WHERE post.id=:id")
        
})
public class Post implements Serializable{
    
    @Id
    @GeneratedValue
    private long id;
    
    @Column(nullable = false)
    private String title;
    
    @Column(columnDefinition = "LONG VARCHAR")
    private String content;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_user", referencedColumnName = "id")
    private User author;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    
    @OneToMany(fetch = FetchType.LAZY,
                mappedBy = "post",
                targetEntity = Comment.class)
    private List<Comment> postComments;
    
    public Post() {
    }

    public Post(User author, String title, String content) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.created = new Date();
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public User getAuthor() {
        return author;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    public void setAuthor(User author) {
        this.author = author;
    }
    
    public Date getCreated() {
        return created;
    }
    
    public PostDTO getInstance(){
        return new PostDTO(this.id, this.title, this.content, this.author.getLogin(), this.created);
    }
    
    public List<Comment> getComments() {
        return postComments;
    }
    
}
