<%@include file="../../init.jsp"%>

<%
    Guestbook guestbook = (Guestbook)request.getAttribute("gb_guestbook");
    System.out.println("guestbook inside full content page is :"+ guestbook);
    guestbook = guestbook.toEscapedModel();
%>

<dl>
    <dt>Name</dt>
    <dd><%= guestbook.getName() %></dd>
</dl>

<h1>hellio</h1>