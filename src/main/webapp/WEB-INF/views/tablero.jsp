
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="stylesheet"
              href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
        <title>TABLERO KAMBAN</title>
    </head>
    <body>
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>TABLERO</h1>
                    <p>lista tareas</p>
                </div>
            </div>
        </section>

        <section class="container">
            <div class="row">
                <c:forEach items="${columnaToDo}" var="tarea">
                    <div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
                        <div class="thumbnail">
                            <div class="caption">
                                <h3>${tarea.titulo}</h3>
                                <p>${tarea.descripcion}</p>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
     
        </section>
    </body>
</html>