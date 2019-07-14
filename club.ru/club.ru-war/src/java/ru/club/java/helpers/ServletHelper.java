/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.club.java.helpers;

import java.io.IOException;
import javax.servlet.http.*;
import javax.xml.ws.http.HTTPException;

/**
 *
 * @author nikitorches
 */
public final class ServletHelper {

    private ServletHelper() {}
    
    public static void redirect (HttpServletRequest req, HttpServletResponse res, String location) 
                                                                    throws HTTPException, IOException{
        res.setHeader("Location", location);
        res.setStatus(302);
    }
    
    public static void redirectToReferer(HttpServletRequest req, HttpServletResponse res)
                                                                    throws HTTPException, IOException{
        String referer = res.getHeader("Referer");
        if (referer == null|| referer.equals(req.getRequestURI().toString())) {
            referer = req.getContextPath();
        }
        redirect(req, res, referer);
    }
    
}
