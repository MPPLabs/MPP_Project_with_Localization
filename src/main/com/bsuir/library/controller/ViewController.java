package main.com.bsuir.library.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.com.bsuir.library.controller.data.AuthorCatalogDataController;
import main.com.bsuir.library.controller.data.AuthorDataController;
import main.com.bsuir.library.controller.data.BookCatalogDataController;
import main.com.bsuir.library.controller.data.BookDataController;
import main.com.bsuir.library.controller.data.BookGenreDataController;
import main.com.bsuir.library.controller.data.BookRaitingDataController;
import main.com.bsuir.library.controller.data.ChatDataController;
import main.com.bsuir.library.controller.data.CommentDataController;
import main.com.bsuir.library.controller.data.GenreDataController;
import main.com.bsuir.library.controller.data.MessageDataController;
import main.com.bsuir.library.controller.data.NewsCommentDataController;
import main.com.bsuir.library.controller.data.NewsDataController;
import main.com.bsuir.library.controller.data.NewsPageDataController;
import main.com.bsuir.library.controller.data.SectionDataController;
import main.com.bsuir.library.controller.data.UserDataController;
import main.com.bsuir.library.controller.exception.DataControllerException;
import main.com.bsuir.library.dao.exception.DaoException;
import main.com.bsuir.library.dataClass.Author;
import main.com.bsuir.library.dataClass.AuthorCatalog;
import main.com.bsuir.library.dataClass.Book;
import main.com.bsuir.library.dataClass.BookCatalog;
import main.com.bsuir.library.dataClass.BookGenre;
import main.com.bsuir.library.dataClass.BookRaiting;
import main.com.bsuir.library.dataClass.Chat;
import main.com.bsuir.library.dataClass.Comment;
import main.com.bsuir.library.dataClass.Genre;
import main.com.bsuir.library.dataClass.Message;
import main.com.bsuir.library.dataClass.News;
import main.com.bsuir.library.dataClass.NewsComment;
import main.com.bsuir.library.dataClass.NewsPage;
import main.com.bsuir.library.dataClass.Section;
import main.com.bsuir.library.dataClass.User;

public class ViewController {

	public void getView(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException, DataControllerException, DaoException, SQLException {

		HttpSession session = request.getSession(true);
		LocaleController sessionLocale = (LocaleController)session.getAttribute("locale");
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
		if( (sessionLocale==null) || (!sessionLocale.getLanguage().equals(language)))
		{
			if(sessionLocale==null)
			{
				sessionLocale = new LocaleController();
				sessionLocale.changeLocale(language, country);
				session.setAttribute("locale", sessionLocale);
			}
			else
			{
				sessionLocale.changeLocale(language, country);
				session.setAttribute("locale", sessionLocale);
			}
		}
		sessionLocale.loadData(request);
		String dbDataLanguage="";
		if(!language.equals("ru"))
		{
			dbDataLanguage="_"+language;
		}
		AuthorCatalogDataController authorCatalogController = new AuthorCatalogDataController();
		authorCatalogController.setAuthorCatalogTableContent(request, dbDataLanguage);
		AuthorDataController authorController = new AuthorDataController();
		authorController.setAuthorTableContent(request, dbDataLanguage);
		BookCatalogDataController bookCatalogController = new BookCatalogDataController();
		bookCatalogController.setBookCatalogTableContent(request, dbDataLanguage);
		BookDataController bookController = new BookDataController();
		bookController.setBookTableContent(request, dbDataLanguage);
		BookGenreDataController bookGenreController = new BookGenreDataController();
		bookGenreController.setBookGenreTableContent(request, dbDataLanguage);
		BookRaitingDataController bookRaitingController = new BookRaitingDataController();
		bookRaitingController.setBookRaitingTableContent(request, dbDataLanguage);
		ChatDataController chatController = new ChatDataController();
		chatController.setChatTableContent(request, dbDataLanguage);
		CommentDataController commentController = new CommentDataController();
		commentController.setCommentTableContent(request, dbDataLanguage);
		GenreDataController genreController = new GenreDataController();
		genreController.setGenreTableContent(request, dbDataLanguage);
		MessageDataController messageController = new MessageDataController();
		messageController.setMessageTableContent(request, dbDataLanguage);
		NewsCommentDataController newsCommentController = new NewsCommentDataController();
		newsCommentController.setNewsCommentTableContent(request, dbDataLanguage);
		NewsDataController newsController = new NewsDataController();
		newsController.setNewsTableContent(request, dbDataLanguage);
		NewsPageDataController newsPageController = new NewsPageDataController();
		newsPageController.setNewsPageTableContent(request, dbDataLanguage);
		SectionDataController sectionController = new SectionDataController();
		sectionController.setSectionTableContent(request, dbDataLanguage);
		UserDataController userController = new UserDataController();
		userController.setUserTableContent(request, dbDataLanguage);
		request.getRequestDispatcher("locale1.jsp").forward(request, response);
		
	}

}
