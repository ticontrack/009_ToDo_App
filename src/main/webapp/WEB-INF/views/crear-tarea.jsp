<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core"%> 
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nueva Tarea</title>
</head>
<body>

	<form:form method="post" modelAttribute="nuevaTarea">
	
	Título: <form:input path="titulo"/> </br>
	Descripción <form:input path="descripcion"/> </br>

     <input type="submit" id="btnCrear" class="btn 
            btn-primary" value ="Crear Nuevo"/> 
	</form:form>

</body>
</html>