<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<html>
 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Редактирование книг</title>
 
<style>
 
    .error {
        color: #ff0000;
    }
</style>
 
</head>
 
<body>
 
    <h2>Редактирование/добавление книги</h2>
  
    <form:form method="POST" modelAttribute="book">
        <form:input type="hidden" path="book_id" id="book_id"/>
        <table>
            <tr>
                <td><label for="title">Название: </label> </td>
                <td><form:input path="title" id="title"/></td>
                <td><form:errors path="title" cssClass="error"/></td>
            </tr>
         
            <tr>
                <td><label for="author">Автор: </label> </td>
                <td><form:input path="author" id="author"/></td>
                <td><form:errors path="author" cssClass="error"/></td>
            </tr>
     
            <tr>
                <td><label for="year">Год: </label> </td>
                <td><form:input path="year" id="year"/></td>
                <td><form:errors path="year" cssClass="error"/></td>
            </tr>
     
            <tr>
                <td colspan="3">
                    <c:choose>
                        <c:when test="${edit}">
                            <input type="submit" value="Обновить"/>
                        </c:when>
                        <c:otherwise>
                            <input type="submit" value="Добавить"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </table>
    </form:form>
    <br/>
    <br/>
    <a href="<c:url value='/list' />">Назад к списку книг</a>
</body>
</html>