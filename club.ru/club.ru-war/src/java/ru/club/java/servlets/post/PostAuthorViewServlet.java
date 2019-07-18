/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.club.java.servlets.post;

import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import ru.club.java.dto.PostDTO;
import ru.club.java.services.PostServiceRemote;

/**
 *
 * @author nikitorches
 */
@WebServlet("/news/posts")
public class PostAuthorViewServlet extends HttpServlet{
    
    @EJB PostServiceRemote postService;
    
    @Inject HttpSession session;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = (String) session.getAttribute("user");
        List<PostDTO> posts = postService.findByAuthor(login);
        req.setAttribute("posts", posts);
        req.getRequestDispatcher("/WEB-INF/pages/post/news-author.jsp").forward(req, resp);
    }
    
    
    
}
