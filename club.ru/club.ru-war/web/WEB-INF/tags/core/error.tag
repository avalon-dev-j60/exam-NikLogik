<%-- 
    Document   : error
    Created on : 23.06.2019, 1:40:04
    Author     : nikitorches
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%@attribute name="error"%>

<c:if test="${not empty error}">
    <div class="box error gap-bottom gap-top">
        ${error}
    </div>  
</c:if>