<%-- 
    Document   : newsForm
    Created on : 04.07.2019, 23:52:53
    Author     : nikitorches
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<fmt:setBundle basename="resources.labels"/>

<fieldset>
    <form name="new-post" method="post" action="${pageContext.servletContext.contextPath}/post-edit">
        <div>
            <legend><h2><fmt:message key="label.post.new_post"/></h2></legend>
            <div class="row">
                <label><fmt:message key="label.post.title"/></label>
                <input name="title" type="text" placeholder="<fmt:message key="label.post.title"/>">
            </div>
            <div class="row">
                <label><fmt:message key="label.post.content"/></label>
                <textarea name="context" 
                          placeholder="<fmt:message key="label.post.content"/>"></textarea>
            </div>
            <button name="action" value="Save" class ="pull-left gap-top">
                <fmt:message key="label.save"/>
            </button>
        </div>
    </form>
</fieldset>