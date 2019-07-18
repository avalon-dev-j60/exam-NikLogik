/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.club.java.servlets;

import java.io.IOException;
import java.util.HashMap;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import ru.club.java.helpers.ServletHelper;
import ru.club.java.dto.UserDTO;
import ru.club.java.services.UserServiceRemote;

/**
 *
 * @author nikitorches
 */
@WebServlet("/profile")
public class ProfileServlet extends HttpServlet{
    
    private static final String JSP = "/WEB-INF/pages/profile.jsp";
    
    @EJB UserServiceRemote userRemote;
    
    @Inject HttpSession session;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = (String) req.getSession().getAttribute("user");
        if (login!=null) {
            UserDTO user = userRemote.find(login);
            if (user!=null) {
                    req.setAttribute("user", user);
                    req.getRequestDispatcher(JSP).forward(req, resp);
                }else{
                    resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            }
        }else {
            ServletHelper.redirectToReferer(req, resp);
        }
    }
}
