<%-- 
    Document   : news
    Created on : 04.07.2019, 0:30:12
    Author     : nikitorches
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="core" tagdir="/WEB-INF/tags/core/" %>
<%@taglib prefix="items" tagdir="/WEB-INF/tags/items/" %>

<fmt:setBundle basename="resources.labels"/>

<core:layout title="News">
    <jsp:body>
        <c:set var="context" value="${pageContext.servletContext.contextPath}"/>
        <c:set var="disabled_button" value="disabled='disabled' aria-disabled='true'"/>
        <div class="row">
            <form method="get" action="${context}/post-edit">
                <button class="red-bg pull-right gap-left" 
                    <c:if test="${empty sessionScope.user}">${disabled_button}</c:if>>
                    <fmt:message key="label.create"/>
                </button>
            </form>
            <form method="get" action="${context}/news/posts">
                <button class="red-bg pull-right" 
                    <c:if test="${empty sessionScope.user}">${disabled_button}</c:if>>
                    <fmt:message key="label.post.show.special"/>
                </button>
            </form>
        </div>
        <div>
            <c:choose>
                <c:when test="${empty posts}">
                    <center>
                        <h3>
                            <fmt:message key="label.post.empty"/>
                        </h3>
                    </center>
                </c:when>
                <c:otherwise>
                    <c:forEach items="${posts}" var="post">
                        <div class="gapped">
                            <h3 class="black gap-bottom border-bottom white"><a href="${context}/news/post?id=${post.id}">
                                ${post.title}
                                </a>
                            </h3>
                                <p data-truncate="5"
                                    class="blue box truncate">
                                    ${post.content}
                            </p>
                            <div class="row">
                                <p><fmt:message key="label.post.created"/>: <fmt:formatDate value="${post.created}" pattern="HH:mm dd-MM-yyyy"/></p>
                                <p><fmt:message key="label.post.author"/>: ${post.author}</p>
                            </div>
                        </div>
                    </c:forEach> 
                </c:otherwise>
            </c:choose>
        </div>
    </jsp:body>
</core:layout>
