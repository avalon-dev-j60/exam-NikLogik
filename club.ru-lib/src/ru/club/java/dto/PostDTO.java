/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.club.java.dto;

import java.util.Date;

/**
 *
 * @author nikitorches
 */
public class PostDTO {
        
    private long id;
    
    private String title;
    
    private String content;
    
    private String author;
    
    private Date created;

    public PostDTO(long id, String title, String content, String author, Date created) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.created = created;
    }

    public PostDTO(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
