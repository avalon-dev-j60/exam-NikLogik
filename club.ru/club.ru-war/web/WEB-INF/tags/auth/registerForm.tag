<%-- 
    Document   : registerForm
    Created on : 01.07.2019, 1:01:43
    Author     : nikitorches
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<fmt:setBundle  basename="resources.labels"/>

<fieldset class="half centered gap-top">
    <legend><h3><fmt:message key="label.registration.title"/></h3></legend>
                <form name="register" action="${pageContext.servletContext.contextPath}/register"
                      method="post">
                    
                    <p class="half inline-block gap-bottom pad-right">
                        <label><fmt:message key="label.user_info.name"/></label>
                        <input name="name" type="text" placeholder="<fmt:message key="label.user_info.name"/>" 
                               value="${param.name}" required>
                    </p>
                    
                    <p class="half inline-block gap-bottom pad-left">
                        <label><fmt:message key="label.user_info.last_name"/></label>
                        <input name="lastName" type="text" placeholder="<fmt:message key="label.user_info.last_name"/>" 
                               value="${param.lastName}" required>
                    </p>
                    
                    <p class="half inline-block gap-bottom pad-right">
                        <label><fmt:message key="label.user_info.login"/></label>
                        <input name="login" type="text" placeholder="<fmt:message key="label.user_info.login"/>" 
                               value="${param.login}" required>
                    </p>
                    
                    <p class="half inline-block gap-bottom pad-left">
                        <label><fmt:message key="label.user_info.email"/></label>
                        <input name="email" type="email" placeholder="<fmt:message key="label.user_info.email"/>" 
                               value="${param.email}" required>
                    </p>

                    <p class="half inline-block gap-bottom pad-right">
                        <label><fmt:message key="label.password"/></label>
                        <input name="password" type="password" placeholder="<fmt:message key="label.password"/>" 
                               required>
                    </p>
                    
                    <p class="half inline-block gap-bottom pad-left">
                        <label><fmt:message key="label.password.confirmation"/></label>
                        <input name="conf_password" type="password" placeholder="<fmt:message key="label.password.confirmation"/>" 
                               required>
                    </p>
                    
                    <p class="half inline-block gap-bottom pad-right">
                        <label><fmt:message key="label.user_info.phone"/></label>
                        <input name="phone" type="text" placeholder="<fmt:message key="label.user_info.phone"/>" 
                               required>
                    </p>

                    <p class="row gap-bottom gap-top">
                        <button class ="pull-left green-bg">
                            <fmt:message key="label.registration.action"/>
                        </button>
                    </p>
                </form>
            </fieldset>