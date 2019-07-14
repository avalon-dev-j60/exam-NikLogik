<%-- 
    Document   : auth_aside
    Created on : 02.07.2019, 22:40:00
    Author     : nikitorches
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<fmt:setBundle basename="resources.labels"/>

<fieldset class="centered">
    
    <div class="container">
        <div class="align-center">
            <legend><h3><fmt:message key="label.sign-in.title"/></h3></legend>
        </div>
        <div class="inline-block">
            <form name="login" action="${pageContext.servletContext.contextPath}/login"
              method="post">
                <div class="column pad-left pad-right">
                    <div>
                        <label><fmt:message key="label.user_info.login"/></label>
                    </div>
                    <div>
                        <input name="login" type="text" 
                               placeholder="<fmt:message key="label.user_info.login"/>" required>
                    </div>
                </div>
                <div class="column pad-left pad-right">
                    <div class="">
                        <label><fmt:message key="label.password"/></label>
                    </div>
                    <div>
                        <input name="password" type="password" placeholder="<fmt:message key="label.password"/>" required>
                    </div>
                </div>
                <div class="column gap-top pad-left pad-right">
                    <button class="green-bg">
                        <fmt:message key="label.sign-in.action"/>
                    </button>
                </div>
            </form>
        </div>
        <div class="inline-block gapped">
            <a href="./register"><fmt:message key="label.registration.title"/></a>
        </div>
    </div>
</fieldset>
