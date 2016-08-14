package com.eticaretforsalesite.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eticaretforsalesite.dao.HibernateDao;
import com.eticaretforsalesite.dao.impl.HibernateDaoImpl;
import com.eticaretforsalesite.model.UserBean;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = LoggerFactory.getLogger(RegisterController.class);
	private static HibernateDao hibernateDao = new HibernateDaoImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		String email = request.getParameter("email");
		String password = request.getParameter("password").toLowerCase();
		String name = request.getParameter("name");
		try {
			userSave(name, email, password);
			response.sendRedirect("Anasayfa.jsp");
		} catch(Exception e){
			logger.error("Kullanıcı kaydı yapılamadı!" + e.getMessage());
		}
	}
	
	public static void userSave(String username, String email, String password) {
		try {
			UserBean musteri = new UserBean();
			musteri.setUserName(username);
			musteri.setUserEmail(email);
			musteri.setUserPassword(password);
			logger.info(musteri.toString());
			hibernateDao.save(musteri);
		} catch (HibernateException e) {
			logger.error(e.getMessage());

		}
	}

}
