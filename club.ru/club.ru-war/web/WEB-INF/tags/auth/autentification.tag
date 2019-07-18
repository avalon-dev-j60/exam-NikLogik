<%-- 
    Document   : autentification
    Created on : 18.06.2019, 0:39:25
    Author     : nikitorches
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<fmt:setBundle basename="resources.labels"/>

<fieldset class="half centered gap-top padded">
    <legend><h3><fmt:message key="label.sign-in.title"/></h3></legend>
    <span class="container inline-block gapped">
        <form name="login" action="${pageContext.servletContext.contextPath}/login"
                      method="post">
        <div class="row gapped">
            <div class="one eighth pad-left">
                <label><fmt:message key="label.user_info.login"/></label>
            </div>
            <div class="six eighths pad-right">
                <input name="login" type="text" placeholder="<fmt:message key="label.user_info.login"/>" required>
            </div>
        </div>
        <div class="row gapped">
            <div class="one eighth padded">
                <label><fmt:message key="label.password"/></label>
            </div>
            <div class="six eighth padded">
                <input name="password" type="password" placeholder="<fmt:message key="label.password"/>" required>
            </div>
        </div> 
        <div>
            <button class="pull-left gap-left">
                <fmt:message key="label.sign-in.action"/>
            </button>
            <div>
        </form>
    </span>
    <span class="padded inline-block">
        <p><fmt:message key="label.message.registration_suggest"/><a href="./register"><fmt:message key="label.message.registration_suggest_href"/></a></p>
    </span>
</fieldset>
