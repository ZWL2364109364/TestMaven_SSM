<%@page import="com.upcome.Student.entity.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	// request.setCharacterEncoding("UTF-8") ;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生信息页面</title>
<script type="text/javascript" src="js/jQuery/jquery-1.4.4.js"></script>
<script type="text/javascript">

	function deleteStudentById(Stu_id){
		console.log("获取id："+Stu_id);
		$.ajax({
			url:"Student/deleteStudentById",
			type:"post",
			data: {
				"Stu_Id":Stu_id,
				"_method":"Delete"
			},
			success:function (data){
				if(data=="1"){
					alert("删除成功")
				}else{
					alert("删除失败")
				}
			}

		})

	}

</script>
</head>
<body>
	<h1 align="center">学生信息管理页</h1>
	
	<a href="Student/StuAddPage">添加学生</a>
	
	<table align="center" style="text-align: center;">
			<tr>
				<td>学生编号</td>
				<td>学生姓名</td>
				<td>学生性别</td>
				<td>学生年龄</td>
				<td>所在班级</td>
				<td>操作</td>
			</tr>
	<c:forEach var="Stu" items="${StuList}">
			<tr>
				<td>${Stu.stu_Id}</td>
				<td>${Stu.stu_Name}</td>
				<td>${Stu.stu_Sex}</td>
				<td>${Stu.stu_Age}</td>
				<td>${Stu.classes.clas_Name}</td>
				<td>
					<a href="<%=request.getContextPath()%>/Student/updateStudentPage?Stu_Id=${Stu.stu_Id}"><button>修改</button></a>
					&emsp;
					<button onclick="deleteStudentById(${Stu.stu_Id})">删除</button>
				</td>
			</tr>
		</c:forEach>
	</table>
	
	<a href="<%=request.getContextPath()%>/index.jsp"><button>返回选择模块页</button></a>
	
</body>
</html>