<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生添加</title>
</head>
<body>

		<form action="<%=request.getContextPath()%>/Student/addStudent" method="post">
		
		<table align="center">
			<tr>
				<td>姓名：<input name="Stu_Name" value="" /></td>
				<td>班级：
				<select  name="classes.clas_Id">
				<c:forEach var="Clas" items="${ListClas}">
						 	<option value="${Clas.clas_Id}">${Clas.clas_Name}</option>
				</c:forEach>
				</select>
				</td>
			</tr>
			<tr>
				<td>性别：<input name="Stu_Sex" value="" /></td>
				<td>年龄： <input name="Stu_Age" value="" /> </td>
			</tr>
			<tr>
				<td><input type="submit" value="提交" /></td>
			</tr>
		</table>
		<input type="hidden" name="_method" value="POST">
		</form>
</body>
</html>