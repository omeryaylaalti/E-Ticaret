package com.eticaretforsalesite.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
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

import com.eticaretforsalesite.model.Urunler;
import com.eticaretforsalesite.util.HibernateUtil;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * Servlet implementation class UrunSepet
 */
@WebServlet("/UrunSepet")
public class UrunSepetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static Logger logger = LoggerFactory.getLogger(UrunSepetServlet.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UrunSepetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	        response.setContentType("text/html;charset=UTF-8");
			String name = request.getParameter("name");
			JsonObject kategoriname = new JsonObject();
			JsonArray data_json = new JsonArray();
			JsonObject json_response = new JsonObject();
			List<Urunler> list = getUrunler(Integer.parseInt(name));
			for (int i = 0; i < list.size(); i++) {
				JsonObject json = new JsonObject();
				json.addProperty("urunid", list.get(i).getUrunId());
				json.addProperty("foto", list.get(i).getUrunFotourl());
				json.addProperty("name", list.get(i).getUrunName());
				json.addProperty("fiyat", list.get(i).getUrunFiyat());
				data_json.add(json);
			}
			data_json.add(kategoriname);
			json_response.add("result", data_json);
			response.getWriter().write(json_response.toString());
			/*logger.info(json_response.toString());
			HttpSession session = request.getSession();
			session.setAttribute("cart", json_response.toString());
			response.sendRedirect("sepet.jsp");
			logger.info(session.toString());*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public static List<Urunler> getUrunler(int id) {
		List<Urunler> list = new ArrayList<Urunler>();
		String sql = "select * from urunler where urunid='" + id + "'";
		Query q = null;
		Session session = HibernateUtil.openSession();
		try {
			q = session.createSQLQuery(sql).addEntity(Urunler.class);
			list = q.list();
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		session.close();
		return list;
	}
	

}
