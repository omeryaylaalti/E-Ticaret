package com.eticaretforsalesite.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eticaretforsalesite.model.Kategoriler;
import com.eticaretforsalesite.model.Urunler;
import com.eticaretforsalesite.util.HibernateUtil;

/**
 * Servlet implementation class UrunEkleveSil
 */
@WebServlet("/UrunEkleveSil")
public class UrunEkleveSil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static Logger logger = LoggerFactory.getLogger(UrunEkleveSil.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UrunEkleveSil() {
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
		int kategoriId = Integer.parseInt(request.getParameter("uruncatid"));
		String urunname = request.getParameter("urunname");
		int urunfiyat = Integer.parseInt(request.getParameter("urunfiyat"));
		int urunstok = Integer.parseInt(request.getParameter("urunstok"));
		String urunPhoto = request.getParameter("urunphoto");
		String urunDetay = request.getParameter("urundetay");

		urunEkle(kategoriId, urunname, urunfiyat, urunstok, urunPhoto, urunDetay);
		response.sendRedirect("urunler.jsp");
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

	public void urunEkle(int kategoriId, String urunname, int urunfiyat, int urunstok, String urunPhoto,
			String urunDetay) {
		List<Kategoriler> kategoriList = new ArrayList<Kategoriler>();
		kategoriList = getenAltKategoriList();
		Kategoriler kategori = new Kategoriler();
		for (int i = 0; i < kategoriList.size(); i++) {
			if (kategoriList.get(i).getId() == kategoriId) {
				kategori = kategoriList.get(i);
				break;
			}
		}
		Urunler urun = new Urunler(urunname, urunfiyat, urunDetay, urunstok, kategori, urunPhoto);
		Session session = HibernateUtil.openSession();
		session.beginTransaction();
		session.save(urun);
		logger.info("Database kayıt işlemi başarıyla gerçekleşti. -->" + urun);
		session.getTransaction().commit();
		session.close();
	}

	public static List<Kategoriler> getenAltKategoriList() {
		List<Kategoriler> list = new ArrayList<Kategoriler>();
		String sql = "select * from kategoriler where status='eALT'";
		Query q = null;
		Session session = HibernateUtil.openSession();
		try {
			q = session.createSQLQuery(sql).addEntity(Kategoriler.class);
			list = q.list();
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		session.close();
		return list;
	}

}
