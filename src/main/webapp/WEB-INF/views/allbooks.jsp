<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Библиотека</title>
 
    <style>
        tr:first-child{
            font-weight: bold;
            background-color: #C6C9C4;
        }
    </style>
 
</head>
<body>
    <h2>Список книг</h2>  
    <table>
        <tr>
            <td>Название</td><td>Автор</td><td>Год</td><td></td><td></td>
        </tr>
        <c:forEach items="${books}" var="book">
            <tr>
            <td>${book.title}</td>
            <td>${book.author}</td>
            <td>${book.year}</td>
            <td><a href="<c:url value='/edit-${book.book_id}-book' />">Редактировать</a></td>
            <td><a href="<c:url value='/delete-${book.book_id}-book' />">Удалить</a></td>
            </tr>
        </c:forEach>
    </table>
    <br/>
    <a href="<c:url value='/new' />">Добавить новую книгу</a>
</body>
</html>