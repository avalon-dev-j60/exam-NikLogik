<%-- 
    Document   : profile
    Created on : 05.07.2019, 23:56:21
    Author     : nikitorches
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="auth" tagdir="/WEB-INF/tags/auth/" %>
<%@taglib prefix="core" tagdir="/WEB-INF/tags/core/" %>
<fmt:setBundle basename="resources.labels"/>

<auth:user_profile>
    <jsp:attribute name="title">
        <fmt:message key="label.profile"/>
    </jsp:attribute>
    <jsp:body>
        <fieldset>
            <div>
                <label><fmt:message key="label.user_info.name"/>: ${user.name}</label>
                <label><fmt:message key="label.user_info.last_name"/>: ${user.lastName}</label>
                <label><fmt:message key="label.user_info.email"/>: ${user.email}</label>
                <label><fmt:message key="label.user_info.login"/>: ${user.login}</label>
                <label><fmt:message key="label.user_info.phone"/>: ${user.phone}</label>
            </div>
        </fieldset>
    </jsp:body>
</auth:user_profile>

