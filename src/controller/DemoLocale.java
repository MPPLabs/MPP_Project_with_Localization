	package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dataClass.*;

import java.util.*;

/**
 * Servlet implementation class DemoLocale
 */
@WebServlet("/DemoLocale")
public class DemoLocale extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DemoLocale() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String temp = request.getParameter("language");
		String language=null;
		String country=null;
		if(temp!=null)
		{
			String[] planguage = temp.split("_");
			language = planguage[0];
			country = planguage[1];
		}
		else
		{
			language="ru";
			country="RU";
		}
		System.out.println(language+country);
		Locale locale = new Locale(language,country);
		ResourceBundle resourceBundle = ResourceBundle.getBundle("resource.content",locale);
		request.setAttribute("author", resourceBundle.getString("author"));
		request.setAttribute("id", resourceBundle.getString("id"));
		request.setAttribute("author_name", resourceBundle.getString("author_name"));
		request.setAttribute("author_female", resourceBundle.getString("author_female"));
		request.setAttribute("author_patronymic", resourceBundle.getString("author_patronymic"));
		request.setAttribute("author_biography", resourceBundle.getString("author_biography"));
		request.setAttribute("book", resourceBundle.getString("book"));
		request.setAttribute("book_name", resourceBundle.getString("book_name"));
		request.setAttribute("book_date", resourceBundle.getString("book_date"));
		request.setAttribute("description", resourceBundle.getString("description"));
		request.setAttribute("book_text_link", resourceBundle.getString("book_text_link"));
		request.setAttribute("author_id", resourceBundle.getString("author_id"));
		request.setAttribute("user", resourceBundle.getString("user"));
		request.setAttribute("login", resourceBundle.getString("login"));
		request.setAttribute("password", resourceBundle.getString("password"));
		request.setAttribute("name", resourceBundle.getString("name"));
		request.setAttribute("female", resourceBundle.getString("female"));
		request.setAttribute("gender", resourceBundle.getString("gender"));
		request.setAttribute("age", resourceBundle.getString("age"));
		request.setAttribute("user_status", resourceBundle.getString("user_status"));
		request.setAttribute("section", resourceBundle.getString("section"));
		request.setAttribute("header_of_smth", resourceBundle.getString("header_of_smth"));
		request.setAttribute("number", resourceBundle.getString("number"));
		request.setAttribute("news_page", resourceBundle.getString("news_page"));
		request.setAttribute("news_status", resourceBundle.getString("news_status"));
		request.setAttribute("news_id", resourceBundle.getString("news_id"));
		request.setAttribute("section_id", resourceBundle.getString("section_id"));
		request.setAttribute("news_comment", resourceBundle.getString("news_comment"));
		request.setAttribute("text", resourceBundle.getString("text"));
		request.setAttribute("publicate_date", resourceBundle.getString("publicate_date"));
		request.setAttribute("user_id", resourceBundle.getString("user_id"));
		request.setAttribute("news", resourceBundle.getString("news"));
		request.setAttribute("message", resourceBundle.getString("message"));
		request.setAttribute("recipient_status", resourceBundle.getString("recipient_status"));
		request.setAttribute("sender_status", resourceBundle.getString("sender_status"));
		request.setAttribute("sender_id", resourceBundle.getString("sender_id"));
		request.setAttribute("recipient_id", resourceBundle.getString("recipient_id"));
		request.setAttribute("genre", resourceBundle.getString("genre"));
		request.setAttribute("comment", resourceBundle.getString("comment"));
		request.setAttribute("book_id", resourceBundle.getString("book_id"));
		request.setAttribute("chat", resourceBundle.getString("chat"));
		request.setAttribute("book_genre", resourceBundle.getString("book_genre"));
		request.setAttribute("genre_id", resourceBundle.getString("genre_id"));
		request.setAttribute("book_catalog", resourceBundle.getString("book_catalog"));
		request.setAttribute("book_status", resourceBundle.getString("book_status"));
		request.setAttribute("author_catalog", resourceBundle.getString("author_catalog"));
		request.setAttribute("author_status", resourceBundle.getString("author_status"));
		request.setAttribute("book_rating", resourceBundle.getString("book_rating"));
		request.setAttribute("raiting_count", resourceBundle.getString("raiting_count"));
		String dbDataLanguage="";
		if(!language.equals("ru"))
		{
			dbDataLanguage="_"+language;
		}
		DBConnection dbConnection = new DBConnection();
		dbConnection.startConnectionToDB();
		ResultSet rs;
		List<Author> authorList = new ArrayList<Author>();
		try {
			rs=dbConnection.getDataFromDB("lib_author");
			while(rs.next())
			{
				Author author = new Author();
				author.setAuthorName(rs.getString("lib_author_name"+dbDataLanguage));
				author.setAuthorFemale(rs.getString("lib_author_female"+dbDataLanguage));
				author.setAuthorPatronymic(rs.getString("lib_author_patronymic"+dbDataLanguage));
				author.setAuthorBiography(rs.getString("lib_author_biography"+dbDataLanguage));
				author.setId(rs.getInt("lib_author_id"));
				authorList.add(author);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("authorList", authorList);
		List<Book> bookList= new ArrayList<Book>();
		try {
			rs=dbConnection.getDataFromDB("lib_book");
			while(rs.next())
			{
				Book book = new Book();
				book.setBookName(rs.getString("lib_book_name"+dbDataLanguage));
				book.setBookDate(rs.getTimestamp("lib_book_date"));
				book.setBookDescription(rs.getString("lib_book_description"+dbDataLanguage));
				book.setBookTextLink(rs.getString("lib_book_text_link"+dbDataLanguage));
				book.setAuthorId(rs.getInt("lib_book_author_id"));
				book.setId(rs.getInt("lib_book_id"));
				bookList.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("bookList", bookList);
		List<User> userList=new ArrayList<User>();
		try{
			rs=dbConnection.getDataFromDB("lib_user");
			while(rs.next())
			{
				User user = new User(rs.getInt("lib_user_id"),rs.getString("lib_user_login"),rs.getString("lib_user_password"),rs.getString("lib_user_name"),
						rs.getString("lib_user_female"),rs.getInt("lib_user_gender"),rs.getInt("lib_user_age"),rs.getInt("lib_user_status"));
				userList.add(user);
			}
		}catch(SQLException e)
		{
			e.printStackTrace();	
		}
		request.setAttribute("userList", userList);
		List<Section> sectionList=new ArrayList<Section>();
		try{
			rs=dbConnection.getDataFromDB("lib_section");
			while(rs.next())
			{
				Section section = new Section(rs.getInt("lib_section_id"),rs.getString("lib_section_name"+dbDataLanguage),rs.getString("lib_section_header"+dbDataLanguage),
						rs.getString("lib_section_description"+dbDataLanguage),rs.getInt("lib_section_number"));
				sectionList.add(section);
			}
		}catch(SQLException e)
		{
			e.printStackTrace();	
		}
		request.setAttribute("sectionList", sectionList);
		List<NewsPage> newsPageList=new ArrayList<NewsPage>();
		try{
			rs=dbConnection.getDataFromDB("lib_news_page");
			while(rs.next())
			{
				NewsPage newsPage = new NewsPage(rs.getInt("lib_news_page_id"),rs.getInt("lib_news_page_status"),rs.getInt("lib_news_id"),rs.getInt("lib_section_id"));
				newsPageList.add(newsPage);
			}
		}catch(SQLException e)
		{
			e.printStackTrace();	
		}
		request.setAttribute("newsPageList", newsPageList);
		List<NewsComment> newsCommentList=new ArrayList<NewsComment>();
		try{
			rs=dbConnection.getDataFromDB("lib_news_comment");
			while(rs.next())	
			{
				NewsComment newsComment = new NewsComment(rs.getInt("lib_news_comment_id"),rs.getString("lib_news_comment_text"+dbDataLanguage),
						rs.getTimestamp("lib_news_comment_date"),rs.getInt("lib_news_id"),rs.getInt("lib_user_id"));
				newsCommentList.add(newsComment);
			}
		}catch(SQLException e)
		{
			e.printStackTrace();	
		}
		request.setAttribute("newsCommentList", newsCommentList);
		List<News> newsList=new ArrayList<News>();
		try{
			rs=dbConnection.getDataFromDB("lib_news");
			while(rs.next())
			{
				News news = new News(rs.getInt("lib_news_id"),rs.getString("lib_news_header"+dbDataLanguage),rs.getString("lib_news_text"+dbDataLanguage),
						rs.getTimestamp("lib_news_date"));
				newsList.add(news);
			}
		}catch(SQLException e)
		{
			e.printStackTrace();	
		}
		request.setAttribute("newsList", newsList);
		List<Message> messageList=new ArrayList<Message>();
		try{
			rs=dbConnection.getDataFromDB("lib_message");
			while(rs.next())
			{
				Message message = new Message(rs.getInt("lib_message_id"),rs.getString("lib_message_text"),rs.getTimestamp("lib_message_date"),
						rs.getInt("lib_message_recipient_status"),rs.getInt("lib_message_sender_status"),rs.getInt("lib_user_sender_id"),
						rs.getInt("lib_user_recipient_id"));
				messageList.add(message);
			}
		}catch(SQLException e)
		{
			e.printStackTrace();	
		}
		request.setAttribute("messageList", messageList);
		List<Genre> genreList=new ArrayList<Genre>();
		try{
			rs=dbConnection.getDataFromDB("lib_genre");
			while(rs.next())
			{
				Genre genre = new Genre(rs.getInt("lib_genre_id"),rs.getString("lib_genre_name"+dbDataLanguage));
				genreList.add(genre);
			}
		}catch(SQLException e)
		{
			e.printStackTrace();	
		}
		request.setAttribute("genreList", genreList);
		List<Comment> commentList=new ArrayList<Comment>();
		try{
			rs=dbConnection.getDataFromDB("lib_comment");
			while(rs.next())
			{
				Comment comment = new Comment(rs.getInt("lib_comment_id"),rs.getString("lib_comment_text"+dbDataLanguage),rs.getTimestamp("lib_comment_date"),
						rs.getInt("lib_book_id"),rs.getInt("lib_sender_id"));
				commentList.add(comment);
			}
		}catch(SQLException e)
		{
			e.printStackTrace();	
		}
		request.setAttribute("commentList", commentList);
		List<Chat> chatList=new ArrayList<Chat>();
		try{
			rs=dbConnection.getDataFromDB("lib_chat");
			while(rs.next())
			{
				Chat chat = new Chat(rs.getInt("lib_chat_id"),rs.getString("lib_chat_message_text"+dbDataLanguage),rs.getTimestamp("lib_chat_message_date"),
						rs.getInt("lib_chat_message_sender_id"));
				chatList.add(chat);
			}
		}catch(SQLException e)
		{
			e.printStackTrace();	
		}
		request.setAttribute("chatList", chatList);
		List<BookRaiting> bookRaitingList=new ArrayList<BookRaiting>();
		try{
			rs=dbConnection.getDataFromDB("lib_book_rating");
			while(rs.next())
			{
				BookRaiting bookRaiting = new BookRaiting(rs.getInt("lib_book_rating_id"),rs.getInt("lib_book_rating_count"),rs.getInt("lib_book_id"),
						rs.getInt("lib_user_id"));
				bookRaitingList.add(bookRaiting);
			}
		}catch(SQLException e)
		{
			e.printStackTrace();	
		}
		request.setAttribute("bookRaitingList", bookRaitingList);
		List<BookGenre> bookGenreList=new ArrayList<BookGenre>();
		try{
			rs=dbConnection.getDataFromDB("lib_book_genre");
			while(rs.next())
			{
				BookGenre bookGenre = new BookGenre(rs.getInt("lib_book_genre_id"),rs.getInt("lib_book_id"),rs.getInt("lib_genre_id"));
				bookGenreList.add(bookGenre);
			}
		}catch(SQLException e)
		{
			e.printStackTrace();	
		}
		request.setAttribute("bookGenreList", bookGenreList);
		List<BookCatalog> bookCatalogList=new ArrayList<BookCatalog>();
		try{
			rs=dbConnection.getDataFromDB("lib_book_catalog");
			while(rs.next())
			{
				BookCatalog bookCatalog = new BookCatalog(rs.getInt("lib_book_catalog_id"),rs.getInt("lib_book_catalog_status"),rs.getInt("lib_book_id"),
						rs.getInt("lib_section_id"));
				bookCatalogList.add(bookCatalog);
			}
		}catch(SQLException e)
		{
			e.printStackTrace();	
		}
		request.setAttribute("bookCatalogList", bookCatalogList);
		List<AuthorCatalog> authorCatalogList=new ArrayList<AuthorCatalog>();
		try{
			rs=dbConnection.getDataFromDB("lib_author_catalog");
			while(rs.next())
			{
				AuthorCatalog authorCatalog = new AuthorCatalog(rs.getInt("lib_author_catalog_id"),rs.getInt("lib_author_catalog_status"),rs.getInt("lib_author_id"),
						rs.getInt("lib_section_id"));
				authorCatalogList.add(authorCatalog);
			}
		}catch(SQLException e)
		{
			e.printStackTrace();	
		}
		request.setAttribute("authorCatalogList", authorCatalogList);
		try {
			dbConnection.closeGettingDataFromDB();
			dbConnection.closeDBConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("locale1.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
