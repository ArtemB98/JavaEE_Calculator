<%@page import="web_classes.MyObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="lab_style.css"/>
        <title>LAB_3_result</title>
    </head>
    <body>
        <%!MyObj a;%>
   <h1 class="styletest1" >Getting the result</h1>
<form>
   <% a = (MyObj)request.getSession().getAttribute("obj");
   if(a == null)
   {
    %>
    <div class='styletest2'>Error! Missing object of the task in session!
    <p>You will be redirected to the first page through 5 seconds... </p></div>
    <meta http-equiv="refresh" content="5; url=index.jsp">
    <a class="type1" href="index.jsp">Redirect now</a><br/><% 
   }
else
{
%><p class="styletest" >1 -st line value:
   <output class="styletest2" id="output"> <%= a.get_f()%> </output>
   <p class="styletest" >2-nd line value:
   <output class="styletest2" id="output"> <%= a.get_s()%> </output><br/>
   <p class="styletest" >Operator:
    <output class="styletest2" id="output"> <%= a.get_oper()%> </output><br/>
    <p class="styletest" >Result:
   <output class="styletest2" id="output"> <%= a.get_res()%> </output><br/>
   <a class="type1" href="index.jsp">Link to the first page</a><br/> 
   <a class="type1" href="result.xml" download>Download file result.xml</a><%
}%>  
  </form>
    <br/>
    </body>
</html>

