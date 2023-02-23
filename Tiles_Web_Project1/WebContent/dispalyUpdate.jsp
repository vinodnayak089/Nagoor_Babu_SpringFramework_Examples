<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="lightblue">
<form action="update.do" method="POST">
	<center>
		<br>
		<br>
		<br>
		<table border=1>
			<tr>
                 <td> Box Size </td>
                 <td>${tiles.boxSize}</td>
                 <td><input type="text" name="boxSize"/></td>
                 
			</tr>
			<tr>
                 <td> Design No </td>
                 <td>${tiles.designNo}</td>
                 <td><input name="designNo" value="${tiles.designNo}" readonly/></td>
			</tr>
			<tr>
                 <td> Light </td>
                 <td>${tiles.quantity.l}</td>
                 <td><input type="text" name="l"/></td>
			</tr>
			<tr>
                 <td> High Lighter </td>
                 <td>${tiles.quantity.hl}</td>
                 <td><input type="text" name="hl"/></td>
			</tr>
			<tr>
                 <td> Dark </td>
                 <td>${tiles.quantity.d}</td>
                 <td><input type="text" name="d"/></td>
			</tr>
			<tr>
                 <td> Flooring </td>
                 <td>${tiles.quantity.f}</td>
                 <td><input type="text" name="f"/></td>
			</tr>
			<tr>
                 <td> Prize </td>
                 <td>${tiles.prize}</td>
                 <td><input type="text" name="prize"/></td>
			</tr>
			<tr>
     <td><input type="submit" value="UPDATE" name="button"/></td>
       </tr>
			
		</table>
	</center>
</form>
</body>
</html>