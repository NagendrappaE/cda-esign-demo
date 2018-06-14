<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <form action="login" method="post">
   
   <table>
    Name : <input type="text" name="name" />
        Password : <input type="password" name="password" /> 
   </table>
     <input type = "submit"  name = "SendOTP" value="SendOTP" class="btn btn-primary  pull-right col-sm-3 " style="width: 90px;margin-right:3px"/>
<!--      <input type = "submit" name = "Verify" value="Verify" class="btn btn-primary  pull-right col-sm-3 " style="width: 90px;margin-right:3px"/> 
 -->                   <align="left"><p><b><i>${message}</i></b></p>
   
   </form>
</body>
</html>