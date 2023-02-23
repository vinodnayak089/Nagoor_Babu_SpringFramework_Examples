<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="lightblue">
	<center>
		<br>
		<br>
		<br>
		<table border=1>
			<tr>
                 <td> Box Size </td>
                 <td>${tiles.boxSize}</td>
			</tr>
			<tr>
                 <td> Design No </td>
                 <td>${tiles.designNo}</td>
			</tr>
			<tr>
                 <td> Light </td>
                 <td>${tiles.quantity.l}</td>
			</tr>
			<tr>
                 <td> High Lighter </td>
                 <td>${tiles.quantity.hl}</td>
			</tr>
			<tr>
                 <td> Dark </td>
                 <td>${tiles.quantity.d}</td>
			</tr>
			<tr>
                 <td> Flooring </td>
                 <td>${tiles.quantity.f}</td>
			</tr>
			<tr>
                 <td> Prize </td>
                 <td>${tiles.prize}</td>
			</tr>
		</table>
	</center>

</body>
</html>