/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.club.java.servlets;

import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import ru.club.java.helpers.ServletHelper;
import ru.club.java.services.AuthServiceUI;


/**
 *
 * @author nikitorches
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet{
    
    @Inject AuthServiceUI authService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        authService.signOut();
        ServletHelper.redirectToReferer(req, resp);
    }
}
