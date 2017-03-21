package main.com.bsuir.library.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.com.bsuir.library.controller.ViewController;

/**
 * Servlet implementation class DemoLocale
 */
@WebServlet("/DemoLocale")
public class DemoLocale extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public DemoLocale() {
        super();
    }

    static {
        try {
            viewController = new ViewController();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    private static final ViewController viewController;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException{
			try {
				viewController.getView(request,response);
			} catch (Exception e) {
				throw new ServletException(e);
			}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException{
		doGet(request, response);
	}

}
