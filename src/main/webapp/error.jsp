<%-- //[START imports]--%>
<%@ page import="com.googlecode.objectify.Key" %>
<%@ page import="com.googlecode.objectify.ObjectifyService" %>
<%-- //[END imports]--%>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ include file="parts/header.jsp" %>

    <h1>An error occured!</h1>

<%
    String errorCode = request.getParameter("errorCode");
    if (errorCode.equals("1")) {
%>
    <p>Seems like no user was logged in. <a href="/landingpage.jsp">Please try again.</a></p>
<%
    } else if (errorCode.equals("2")) {
%>
    <p>Seems like you are already member in another group. <a href="/landingpage.jsp">Please try again.</a></p>
<%
    } else {
%>
    <p>We do not know what exactly was the problem. <a href="/landingpage.jsp">Please try again.</a></p>
<%
    }
%>

<%@ include file="parts/footer.jsp" %>
<%-- //[END all]--%>
