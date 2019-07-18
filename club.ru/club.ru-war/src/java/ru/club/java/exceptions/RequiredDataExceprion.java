/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.club.java.exceptions;

/**
 *
 * @author nikitorches
 */
public class RequiredDataExceprion extends Exception {

    public RequiredDataExceprion() {
    }

    public RequiredDataExceprion(String message) {
        super(message);
    }
    
}
