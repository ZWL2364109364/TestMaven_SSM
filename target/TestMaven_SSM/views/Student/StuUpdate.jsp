<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改学生信息页面</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jQuery/jquery-1.4.4.js"></script>
<script type="text/javascript">
	function subOnlick(){
		var Stu_Name=$("#Stu_Name").val();
		var clas_Id=$("#clas_Id").val();
		var Stu_Sex=$("#Stu_Sex").val();
		var Stu_Age=$("#Stu_Age").val();
		var StuId=$("#Stu_Id").val();
		
		$.ajax({
			url:"<%=request.getContextPath()%>/Student/updateStudentSub",
			type:"POST",
			data:{"_method":"PUT","Stu_Name":Stu_Name,"clases.clas_Id":clas_Id,"Stu_Sex":Stu_Sex,"Stu_Age":Stu_Age,"Stu_Id":StuId},
			success:function(data){
				if(data==1){
					alert("更改成功");
				}else{
					alert("更改失败");
				}
				
			}
		})	
		
	}
	
	
</script>
</head>
<body>
		<h3 align="center">学生管理模块：修改学生信息</h3>
		<form id="form1" onsubmit="return false" action="##" method="post">
			<table align="center">
				<tr>
					<td>学生姓名：<input id="Stu_Name" name="Stu_Name" type="text" value="${stuS.stu_Name}"></td>
					<td>学生班级：
						<select id="clas_Id" name="clases.clas_Id">
							<c:forEach var="cla" items="${clasList}">
								<option value="${cla.clas_Id}" ${stuS.classes.clas_Name==cla.clas_Name ? 'selected':''} >${cla.clas_Name}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<td>学生性别：<input id="Stu_Sex" name="Stu_Sex" type="text" value="${stuS.stu_Sex}"></td>
				<td>学生年龄：<input id="Stu_Age" name="Stu_Age" type="text" value="${stuS.stu_Age}"></td>
			</table>
			<input name="StuId" id="Stu_Id" type="hidden" value="${stuS.stu_Id}" />
			<input type="submit" value="提交" onclick="subOnlick()">
		</form>
		
		<!-- <a href="javascript:" onclick="self.location=document.referrer;"><button>返回上一页并刷新</button></a> -->
		<a href="<%=request.getContextPath()%>/StuCon/selectStudent.action"><button>返回上一页并刷新</button></a>
	
</body>
</html>