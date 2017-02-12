<%@ page language="java" contentType="text/html"  pageEncoding="utf-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="DemoLocale?language=en_US">EN</a>
	<a href="DemoLocale?language=ru_RU">RU</a>
	<h3>${author }</h3>
	<table border=1px>
		<tr>
			<td>${id }</td>
			<td>${author_name }</td>
			<td>${author_female }</td>
			<td>${author_patronymic }</td>
			<td>${author_biography }</td>
		</tr>
		
	<%--<c:if test="${!empty authorList}">--%>

            <c:forEach items="${authorList}" var="author">
              <tr>
                       <td>${author.id}</td>
                       <td>${author.authorName}</td>
                       <td>${author.authorFemale}</td>
                       <td>${author.authorPatronymic}</td>
                       <td>${author.authorBiography}</td>
                </tr>
            </c:forEach>

    <%--</c:if>--%>
	</table>
	
	
		<h3>${book }</h3>
	<table border=1px>
		<tr>
			<td>${id }</td>
			<td>${book_name }</td>
			<td>${book_date }</td>
			<td>${description }</td>
			<td>${book_text_link }</td>
			<td>${author_id }</td>
		</tr>
		
	<%--<c:if test="${!empty bookList}">--%>

            <c:forEach items="${bookList}" var="book">
              <tr>
                       <td>${book.id}</td>
                       <td>${book.bookName}</td>
                       <td>${book.bookDate}</td>
                       <td>${book.bookDescription}</td>
                       <td>${book.bookTextLink}</td>
                       <td>${book.authorId}</td>
                </tr>
            </c:forEach>

    <%--</c:if>--%>
	</table>
	<h3>${user }</h3>
	<table border=1px>
		<tr>
			<td>${id }</td>
			<td>${login }</td>
			<td>${password }</td>
			<td>${name }</td>
			<td>${female }</td>
			<td>${gender }</td>
			<td>${age }</td>
			<td>${user_status }</td>
		</tr>
		
		
	<%--<c:if test="${!empty userList}">--%>

            <c:forEach items="${userList}" var="user">
              <tr>
                       <td>${user.id}</td>
                       <td>${user.login}</td>
                       <td>${user.password}</td>
                       <td>${user.name}</td>
                       <td>${user.female}</td>
                       <td>${user.gender}</td>
                       <td>${user.age}</td>
                       <td>${user.status}</td>
                </tr>
            </c:forEach>

    <%--</c:if>--%>
	</table>
	<h3>${section }</h3>
	<table border=1px>
		<tr>
			<td>${id }</td>
			<td>${name }</td>
			<td>${header_of_smth }</td>
			<td>${description }</td>
			<td>${number }</td>
		</tr>
		
		
	<%--<c:if test="${!empty sectionList}">--%>

            <c:forEach items="${sectionList}" var="section">
              <tr>
                       <td>${section.id}</td>
                       <td>${section.name}</td>
                       <td>${section.header}</td>
                       <td>${section.description}</td>
                       <td>${section.number}</td>
                </tr>
            </c:forEach>

    <%--</c:if>--%>
	</table>
	
	<h3>${news_page }</h3>
	<table border=1px>
		<tr>
			<td>${id }</td>
			<td>${news_status }</td>
			<td>${news_id }</td>
			<td>${section_id }</td>
		</tr>
	<%--<c:if test="${!empty newsPageList}">--%>
            <c:forEach items="${newsPageList}" var="newsPage">
              <tr>
                       <td>${newsPage.id}</td>
                       <td>${newsPage.newsStatus}</td>
                       <td>${newsPage.newsId}</td>
                       <td>${newsPage.sectionId}</td>
                </tr>
            </c:forEach>
    <%--</c:if>--%>
	</table>
	<h3>${news_comment }</h3>
	<table border=1px>
		<tr>
			<td>${id }</td>
			<td>${text }</td>
			<td>${publicate_date }</td>
			<td>${news_id }</td>
			<td>${user_id }</td>
		</tr>
	<%--<c:if test="${!empty newsCommentList}">--%>
            <c:forEach items="${newsCommentList}" var="newsComment">
              <tr>
                       <td>${newsComment.id}</td>
                       <td>${newsComment.text}</td>
                       <td>${newsComment.publicateDate}</td>
                       <td>${newsComment.newsId}</td>
                       <td>${newsComment.userId}</td>
                </tr>
            </c:forEach>
    <%--</c:if>--%>
	</table>
	<h3>${news }</h3>
	<table border=1px>
		<tr>
			<td>${id }</td>
			<td>${header_of_smth }</td>
			<td>${text }</td>
			<td>${publicate_date }</td>
		</tr>
	<%--<c:if test="${!empty newsList}">--%>
            <c:forEach items="${newsList}" var="news">
              <tr>
                       <td>${news.id}</td>
                       <td>${news.header}</td>
                       <td>${news.text}</td>
                       <td>${news.publicateDate}</td>
                </tr>
            </c:forEach>
    <%--</c:if>--%>
	</table>
	<h3>${message }</h3>
	<table border=1px>
		<tr>
			<td>${id }</td>
			<td>${text }</td>
			<td>${publicate_date }</td>
			<td>${recipient_status }</td>
			<td>${sender_status }</td>
			<td>${sender_id }</td>
			<td>${recipient_id }</td>
		</tr>
	<%--<c:if test="${!empty messageList}">--%>
            <c:forEach items="${messageList}" var="message">
              <tr>
                       <td>${message.id}</td>
                       <td>${message.text}</td>
                       <td>${message.publicateDate}</td>
                       <td>${message.recipientStatus}</td>
                       <td>${message.senderStatus}</td>
                       <td>${message.senderId}</td>
                       <td>${message.recipientId}</td>
                </tr>
            </c:forEach>
    <%--</c:if>--%>
	</table>
	<h3>${genre }</h3>
	<table border=1px>
		<tr>
			<td>${id }</td>
			<td>${genre }</td>
		</tr>
	<%--<c:if test="${!empty genreList}">--%>
            <c:forEach items="${genreList}" var="genre">
              <tr>
                       <td>${genre.id}</td>
                       <td>${genre.genre}</td>
                </tr>
            </c:forEach>
    <%--</c:if>--%>
	</table>
	<h3>${comment }</h3>
	<table border=1px>
		<tr>
			<td>${id }</td>
			<td>${text }</td>
			<td>${publicate_date }</td>
			<td>${book_id }</td>
			<td>${sender_id }</td>
		</tr>
	<%--<c:if test="${!empty commentList}">--%>
            <c:forEach items="${commentList}" var="comment">
              <tr>
                       <td>${comment.id}</td>
                       <td>${comment.text}</td>
                       <td>${comment.publicateDate}</td>
                       <td>${comment.bookId}</td>
                       <td>${comment.senderId}</td>
                </tr>
            </c:forEach>
    <%--</c:if>--%>
	</table>
	<h3>${chat }</h3>
	<table border=1px>
		<tr>
			<td>${id }</td>
			<td>${text }</td>
			<td>${publicate_date }</td>
			<td>${sender_id }</td>
		</tr>
	<%--<c:if test="${!empty chatList}">--%>
            <c:forEach items="${chatList}" var="chat">
              <tr>
                       <td>${chat.id}</td>
                       <td>${chat.text}</td>
                       <td>${chat.publicateDate}</td>
                       <td>${chat.senderId}</td>
                </tr>
            </c:forEach>
    <%--</c:if>--%>
	</table>
	<h3>${book_rating }</h3>
	<table border=1px>
		<tr>
			<td>${id }</td>
			<td>${raiting_count }</td>
			<td>${book_id }</td>
			<td>${user_id }</td>
		</tr>
	<%--<c:if test="${!empty bookRaitingList}">--%>
            <c:forEach items="${bookRaitingList}" var="bookRaiting">
              <tr>
                       <td>${bookRaiting.id}</td>
                       <td>${bookRaiting.raitingCount}</td>
                       <td>${bookRaiting.bookId}</td>
                       <td>${bookRaiting.userId}</td>
                </tr>
            </c:forEach>
    <%--</c:if>--%>
	</table>
	<h3>${book_genre }</h3>
	<table border=1px>
		<tr>
			<td>${id }</td>
			<td>${book_id }</td>
			<td>${genre_id }</td>
		</tr>
	<%--<c:if test="${!empty bookGenreList}">--%>
            <c:forEach items="${bookGenreList}" var="bookGenre">
              <tr>
                       <td>${bookGenre.id}</td>
                       <td>${bookGenre.bookId}</td>
                       <td>${bookGenre.genreId}</td>
                </tr>
            </c:forEach>
    <%--</c:if>--%>
	</table>
	<h3>${book_catalog }</h3>
	<table border=1px>
		<tr>
			<td>${id }</td>
			<td>${book_status }</td>
			<td>${book_id }</td>
			<td>${section_id }</td>
		</tr>
	<%--<c:if test="${!empty bookCatalogList}">--%>
            <c:forEach items="${bookCatalogList}" var="bookCatalog">
              <tr>
                       <td>${bookCatalog.id}</td>
                       <td>${bookCatalog.bookStatus}</td>
                       <td>${bookCatalog.bookId}</td>
                       <td>${bookCatalog.sectionId}</td>
                </tr>
            </c:forEach>
    <%--</c:if>--%>
	</table>
	<h3>${author_catalog }</h3>
	<table border=1px>
		<tr>
			<td>${id }</td>
			<td>${author_status }</td>
			<td>${author_id }</td>
			<td>${section_id }</td>
		</tr>
			
	<%--<c:if test="${!empty authorCatalogList}">--%>

            <c:forEach items="${authorCatalogList}" var="authorCatalog">
              <tr>
                       <td>${authorCatalog.id}</td>
                       <td>${authorCatalog.authorStatus}</td>
                       <td>${authorCatalog.authorId}</td>
                       <td>${authorCatalog.sectionId}</td>
                </tr>
            </c:forEach>

    <%--</c:if>--%>
	</table>
</body>
</html>