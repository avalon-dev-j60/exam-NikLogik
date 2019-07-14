/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.club.java.servlets;

import java.io.IOException;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.naming.AuthenticationException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ru.club.java.dto.UserDTO;
import ru.club.java.helpers.ServletHelper;
import ru.club.java.services.AuthServiceUI;
import ru.club.java.services.UserServiceRemote;

/**
 *
 * @author nikitorches
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    
    @Inject AuthServiceUI authService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        try {
            authService.signIn(login, password);
            ServletHelper.redirect(req, resp, req.getContextPath());
        } catch (AuthenticationException e) {
            req.setAttribute("error", e.getMessage());
            doGet(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/pages/auth/login.jsp").forward(req, resp);
    }
}
