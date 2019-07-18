<%-- 
    Document   : index
    Created on : 28.06.2019, 1:54:43
    Author     : nikitorches
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="core" tagdir="/WEB-INF/tags/core/" %>
<%@taglib prefix="auth" tagdir="/WEB-INF/tags/auth/" %>

<core:layout title="Main page">
    
    <jsp:body>
        <h2>Добро пожаловать!</h2>
        <p>Перейдите в раздел "Новости" чтобы создать свой первый пост 
            <c:if test="${empty user}">, но сначала Вам необходимо пройти <a href="./register">регистрацию.</a></p></c:if>
    </jsp:body>
    
</core:layout>
