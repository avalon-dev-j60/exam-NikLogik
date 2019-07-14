<%-- 
    Document   : newsForm
    Created on : 04.07.2019, 23:52:53
    Author     : nikitorches
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<fmt:setBundle basename="resources.labels"/>

<fieldset>
    <form name="update-post" method="post" action="${pageContext.servletContext.contextPath}/post-edit">
        <div>
            <legend><h2>Update</h2></legend>
            <div class="row">
                <label><fmt:message key="label.post.title"/></label>
                <input name="title" type="text" value="${update_post.title}">
            </div>
            <div class="row">
                <label><fmt:message key="label.post.content"/></label>
                <textarea name="context">${update_post.content}</textarea>
            </div>
            <button class ="pull-left gap-top" name="action" value="Update">
                <fmt:message key="label.edit"/>
            </button>
        </div>
    </form>
</fieldset>
            