/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.club.java.servlets.post;

import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import ru.club.java.dto.PostDTO;
import ru.club.java.services.PostServiceRemote;

/**
 *
 * @author nikitorches
 */
@WebServlet("/news")
public class PostServlet extends HttpServlet{
    
    private static final String JSP = "/WEB-INF/pages/post/news.jsp";
    
    @EJB PostServiceRemote postService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<PostDTO> posts = postService.findAll();
        req.setAttribute("posts", posts);
        req.getRequestDispatcher(JSP).forward(req, resp);
    }
}
