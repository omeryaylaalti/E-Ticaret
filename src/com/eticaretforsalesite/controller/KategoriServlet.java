package com.eticaretforsalesite.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
import com.eticaretforsalesite.util.HibernateUtil;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * Servlet implementation class KategoriServlet
 */
@WebServlet("/KategoriListele")
public class KategoriServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = LoggerFactory.getLogger(KategoriServlet.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public KategoriServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		JsonArray data_json = new JsonArray();
		JsonObject json_response = new JsonObject();
		List<Kategoriler> list = getUstKategoriList();
		for (int i = 0; i < list.size(); i++) {
			JsonObject json = new JsonObject();
			json.addProperty("text", list.get(i).getCat_name());
			json.addProperty("id", list.get(i).getId());
			data_json.add(json);
			List<Kategoriler> altlist = getAltKategoriList(list.get(i).getId());
			JsonArray alt_data_json = new JsonArray();
			for (int j = 0; j < altlist.size(); j++) {
				JsonObject altjson = new JsonObject();
				altjson.addProperty("altid", altlist.get(j).getId());
				altjson.addProperty("alttext", altlist.get(j).getCat_name());
				alt_data_json.add(altjson);
				List<Kategoriler> enaltlist = getenAltKategoriList(altlist.get(j).getId());
				JsonArray en_alt_data_json = new JsonArray();
				for(int k=0;k<enaltlist.size();k++){
					JsonObject enaltjson = new JsonObject();
					enaltjson.addProperty("enaltid", enaltlist.get(k).getId());
					enaltjson.addProperty("enalttext", enaltlist.get(k).getCat_name());
					en_alt_data_json.add(enaltjson);
				}
				altjson.add("enaltsonuc", en_alt_data_json);
			}
			json.add("altsonuc", alt_data_json);
		}
		json_response.add("result", data_json);
		logger.info(json_response.toString());
		response.getWriter().write(json_response.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	
	public static String getId(String name) {
		String result = null;
		String sql = "select id from kategoriler where catname='" + name + "'";
		Query q = null;
		Session session = HibernateUtil.openSession();
		try {
			q = session.createSQLQuery(sql).addEntity(Kategoriler.class);
			result = q.getQueryString();
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		session.close();
		return result;
	}

	public static List<Kategoriler> getUstKategoriList() {
		List<Kategoriler> list = new ArrayList<Kategoriler>();
		String sql = "select * from kategoriler where status='UST'";
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

	public static List<Kategoriler> getAltKategoriList(int id) {
		List<Kategoriler> list = new ArrayList<Kategoriler>();
		String sql = "select * from kategoriler where status='ALT' and ustcatid='" + id + "'";
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

	public static List<Kategoriler> getenAltKategoriList(int id) {
		List<Kategoriler> list = new ArrayList<Kategoriler>();
		String sql = "select * from kategoriler where status='eALT' and ustcatid='" + id + "'";
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
