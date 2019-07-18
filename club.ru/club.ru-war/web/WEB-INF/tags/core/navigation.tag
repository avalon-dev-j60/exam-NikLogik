<%-- 
    Document   : navigation
    Created on : 15.06.2019, 13:10:57
    Author     : JAVA
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<fmt:setBundle basename="resources.labels"/>

<nav class="nav fadeInDown animated" title="Software development blog">
    <div class="row ">
        <div class="ten twelfth">
            <ul class="left">
                <li>
                    <a href="${pageContext.servletContext.contextPath}/">
                        <fmt:message key="label.main_page"/>
                    </a>
                </li>
                <li>
                    <a href="${pageContext.servletContext.contextPath}/news">
                        <fmt:message key="label.news"/>
                    </a>
                </li>
                <li>
                    <a href="${pageContext.servletContext.contextPath}/team">
                        <fmt:message key="label.team"/>
                    </a>
                </li>
                <li>
                    <a href="${pageContext.servletContext.contextPath}/results">
                        <fmt:message key="label.results"/>
                    </a>
                </li>
                <li>
                    <a href="${pageContext.servletContext.contextPath}/contacts">
                        <fmt:message key="label.contacts"/>
                    </a>
                </li> 
            </ul>
        </div>
        <div class="two twelfth vertical-center">
            <ul>
                <li>
                    <c:choose>
                        <c:when test="${empty sessionScope.user}">
                            <a href="${pageContext.servletContext.contextPath}/login">
                                <fmt:message key="label.sign-in.action"/>  
                            </a>
                        </c:when>
                        <c:otherwise>
                                <li>
                                    <form name="profile" method="get" action="${pageContext.servletContext.contextPath}/profile">
                                        <button><fmt:message key="label.profile"/></button>
                                    </form>
                                </li>
                                <li>
                                    <form name="logout" method="get" action="${pageContext.servletContext.contextPath}/logout">
                                        <button><fmt:message key="label.sign-out"/></button>
                                    </form>
                                </li>
                        </c:otherwise>
                    </c:choose>
                </li>
            </ul>          
        </div>
    </div>
</nav>
