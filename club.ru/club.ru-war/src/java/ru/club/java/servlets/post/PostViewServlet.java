/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.club.java.servlets.post;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import ru.club.java.dto.PostDTO;
import ru.club.java.exceptions.ValidationException;
import ru.club.java.helpers.ServletHelper;
import ru.club.java.helpers.ValidationHelper;
import ru.club.java.services.PostServiseUI;

/**
 *
 * @author nikitorches
 */
@WebServlet("/news/post")
public class PostViewServlet extends HttpServlet {
    
    @EJB PostServiseUI postService;
    
    @Inject HttpSession session;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = (String) req.getParameter("action");
        long lId = Long.parseLong(req.getParameter("post"));
        PostDTO post;
        post = postService.find(lId);
        if (post!=null){
            switch(action){
                case "Delete":
                    postService.delete(post);
                    ServletHelper.redirect(req, resp, req.getContextPath());
                    break;
                case "Update":
                    session.setAttribute("update_post", post);
                    ServletHelper.redirect(req, resp, req.getContextPath() + "/post-edit");
                    break;
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        try {
            ValidationHelper.requireNonNull(id, "Post does not exist");
            long lid = Long.parseLong(id);
            PostDTO post = postService.find(lid);
            ValidationHelper.requireNonNull(post, "Post does not exist");
            req.setAttribute("post", post);
            req.getRequestDispatcher("/WEB-INF/pages/post/news-view.jsp").forward(req, resp);
        } catch (ValidationException ex) {
            ex.getMessage();
        }
    }
}
