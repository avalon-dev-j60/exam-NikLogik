<%-- 
    Document   : user_aside
    Created on : 02.07.2019, 22:39:48
    Author     : nikitorches
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<fmt:setBundle basename="resources.labels"/>

<div class="box">
    
        <label class="align-center"><h3>
            ${user}
            </h3>
        </label>
        <img class="round" src="pic/default-icon.jpg" alt="default_icon"></img>
    <form name="logout" method="get" action="${pageContext.servletContext.contextPath}/logout">
        <button class=" center red-bg"><fmt:message key="label.sign-out"/></button>
    </form>
</div>
