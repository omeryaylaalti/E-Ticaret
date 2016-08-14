package com.eticaretforsalesite.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eticaretforsalesite.model.UserBean;
import com.eticaretforsalesite.model.YetkiBean;
import com.eticaretforsalesite.util.HibernateUtil;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/Login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = LoggerFactory.getLogger(LoginController.class);
	private static String username = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		String email = request.getParameter("email").toLowerCase();
		String password = request.getParameter("password").toLowerCase();
		List<YetkiBean> list = getYetki();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getYetkiName().trim().toLowerCase().equals(email)) {
				logger.info(list.get(i).getYetkiName());
				response.sendRedirect("AdminPaneli.jsp");
			}
		}

		List<UserBean> userList = getKullanicilar();
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getUserEmail().toLowerCase().equals(email)
					|| userList.get(i).getUserPassword().toLowerCase().equals(password)) {
				username = userList.get(i).getUserName();
				response.sendRedirect("Anasayfa.jsp");
				request.setAttribute("name", username);
			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

	}

	public static List<YetkiBean> getYetki() {
		List<YetkiBean> list = new ArrayList<YetkiBean>();
		String sql = "select * from yetki";
		Query q = null;
		Session session = HibernateUtil.openSession();
		try {
			q = session.createSQLQuery(sql).addEntity(YetkiBean.class);
			list = q.list();
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		session.close();
		return list;
	}

	public static List<UserBean> getKullanicilar() {
		List<UserBean> list = new ArrayList<UserBean>();
		String sql = "select * from müsteri";
		Query q = null;
		Session session = HibernateUtil.openSession();
		try {
			q = session.createSQLQuery(sql).addEntity(UserBean.class);
			list = q.list();
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		session.close();
		return list;
	}

}
