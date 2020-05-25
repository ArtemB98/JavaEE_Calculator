<%-- 
    Document   : index
    Created on : 21.04.2019, 23:31:25
    Author     : 123
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page  import="web_classes.*" %>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="lab_style.css"/>
        <title>LAB_3_index</title>
    </head>
    <body>
    <h1 class="styletest1" >Calculator</h1>
<form action ="index.jsp">
   <p class="styletest" >Enter 1 -st operand:
   <input name="fp" value="<%= (request.getParameter("fp")!=null)?request.getParameter("fp"):""%>"  class = "<%= (request.getParameter("fp") !=null && request.getParameter("fp") != "")?"styletest2":"wrongg"%>"><%= (request.getParameter("fp")!=null && request.getParameter("fp") != "")?"":"<--Enter data!"%>
   <p class="styletest" >Enter 2-nd operand:
   <input name="sp" value="<%=(request.getParameter("sp")!=null)?request.getParameter("sp"):""%>" class = "<%= (request.getParameter("sp") !=null && request.getParameter("sp") != "")?"styletest2":"wrongg"%>"><%= (request.getParameter("sp")!=null && request.getParameter("sp") != "")?"":"<--Enter data!"%><p>
    <input type="submit" name="op" value="+" />
    <input type="submit" name="op" value="-" />
    <input type="submit" name="op" value="*" />
    <input type="submit" name="op" value="/" />
</form>  
    <%
        if(request.getParameter("fp")!= "" && request.getParameter("sp")!= "" && request.getParameter("fp")!= null && request.getParameter("sp")!= null)
        {
            String oper = request.getParameter("op");
            if(oper.equals("+"))
                request.getSession().setAttribute("obj", new MyObj(request.getParameter("fp"),request.getParameter("sp"), 1));
            else if(oper.equals("-"))
                request.getSession().setAttribute("obj", new MyObj(request.getParameter("fp"),request.getParameter("sp"), 2));
            else if(oper.equals("*"))
                request.getSession().setAttribute("obj", new MyObj(request.getParameter("fp"),request.getParameter("sp"), 3));
            else
                request.getSession().setAttribute("obj", new MyObj(request.getParameter("fp"),request.getParameter("sp"), 4));
            response.sendRedirect("result.html");
        } 
    %>
    </body>
</html>
