/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.club.java.servlets;

import java.io.IOException;
import javax.inject.Inject;
import javax.naming.AuthenticationException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ru.club.java.exceptions.RequiredDataExceprion;
import ru.club.java.helpers.ServletHelper;
import ru.club.java.services.AuthServiceUI;

/**
 *
 * @author nikitorches
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet{
    
    @Inject AuthServiceUI authService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String name = req.getParameter("name");
        String lastName = req.getParameter("lastName");
        String login = req.getParameter("login");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String confPassword = req.getParameter("conf_password");
        String phone = req.getParameter("phone");
        try {
            authService.register(name, lastName, login, password, confPassword, email, phone);
            ServletHelper.redirect(req, resp, req.getContextPath());
        } catch (AuthenticationException | RequiredDataExceprion e) {
            req.setAttribute("error", e.getMessage());
            doGet(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/pages/auth/register.jsp");
        dispatcher.forward(req, resp);
    }
}
