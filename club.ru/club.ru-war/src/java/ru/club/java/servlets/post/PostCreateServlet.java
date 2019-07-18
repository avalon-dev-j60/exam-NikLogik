/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.club.java.servlets.post;

import java.io.IOException;
import javax.inject.Inject;
import javax.jws.WebService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import ru.club.java.dto.PostDTO;
import ru.club.java.helpers.ServletHelper;
import ru.club.java.services.AuthServiceUI;
import ru.club.java.services.PostServiseUI;

/**
 *
 * @author nikitorches
 */
@WebServlet("/post-edit")
public class PostCreateServlet extends HttpServlet{
        
    @Inject PostServiseUI postService;
    
    @Inject HttpSession session;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String context = req.getParameter("context");
        try {
            String action = req.getParameter("action");
            switch(action){
                case "Save":
                    postService.createNewPost(title, context);
                    ServletHelper.redirect(req, resp, req.getContextPath() + "/news");
                    break;
                case "Update":
                    PostDTO post = (PostDTO) session.getAttribute("update_post");
                    post.setTitle(title);
                    post.setContent(context);
                    postService.update(post);
                    session.removeAttribute("update_post");
                    ServletHelper.redirect(req, resp, req.getContextPath() + "/news");
                    break;
            }
        } catch (IllegalArgumentException e) {
            req.setAttribute("error", e.getMessage());
            doGet(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (session.getAttribute("user")==null) {
            req.setAttribute("error", "You must login before for creating new posts");
            ServletHelper.redirect(req, resp, req.getContextPath());
        }
        PostDTO post = (PostDTO) session.getAttribute("update_post");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/pages/post/new-post.jsp");
        dispatcher.forward(req, resp); 
    }
}
