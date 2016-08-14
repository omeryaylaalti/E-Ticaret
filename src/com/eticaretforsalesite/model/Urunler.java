package com.eticaretforsalesite.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Urunler")
public class Urunler {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "urunId")
	private int urunId;

	@Column(name = "urunName")
	private String urunName;

	@Column(name = "urunFiyat")
	private int urunFiyat;

	@Column(name = "urunDetay")
	private String urunDetay;

	@Column(name = "urunStok")
	private int stok;

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name="kategoriId")
	private Kategoriler kategori;

	@Column(name = "urunfotoUrl")
	private String urunFotourl;

	@Column(name = "urunYorum")
	private String urunYorum;

	@Column(name = "urunBegeni")
	private int urunBegeni;

	public int getUrunId() {
		return urunId;
	}

	public void setUrunId(int urunId) {
		this.urunId = urunId;
	}

	public String getUrunName() {
		return urunName;
	}

	public void setUrunName(String urunName) {
		this.urunName = urunName;
	}

	public int getUrunFiyat() {
		return urunFiyat;
	}

	public void setUrunFiyat(int urunFiyat) {
		this.urunFiyat = urunFiyat;
	}

	public String getUrunDetay() {
		return urunDetay;
	}

	public void setUrunDetay(String urunDetay) {
		this.urunDetay = urunDetay;
	}

	public int getStok() {
		return stok;
	}

	public void setStok(int stok) {
		this.stok = stok;
	}

	

	public String getUrunFotourl() {
		return urunFotourl;
	}

	public void setUrunFotourl(String urunFotourl) {
		this.urunFotourl = urunFotourl;
	}

	public String getUrunYorum() {
		return urunYorum;
	}

	public void setUrunYorum(String urunYorum) {
		this.urunYorum = urunYorum;
	}

	public int getUrunBegeni() {
		return urunBegeni;
	}

	public void setUrunBegeni(int urunBegeni) {
		this.urunBegeni = urunBegeni;
	}

	public Urunler() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	

	public Urunler(String urunName, int urunFiyat, String urunDetay, int stok, Kategoriler kategori,
			String urunFotourl) {
		super();
		this.urunName = urunName;
		this.urunFiyat = urunFiyat;
		this.urunDetay = urunDetay;
		this.stok = stok;
		this.kategori = kategori;
		this.urunFotourl = urunFotourl;
	}

	public Kategoriler getKategori() {
		return kategori;
	}

	public void setKategori(Kategoriler kategori) {
		this.kategori = kategori;
	}

	@Override
	public String toString() {
		return "Urunler [urunId=" + urunId + ", urunName=" + urunName + ", urunFiyat=" + urunFiyat + ", urunDetay="
				+ urunDetay + ", stok=" + stok + ", kategori=" + kategori + ", urunFotourl=" + urunFotourl
				+ ", urunYorum=" + urunYorum + ", urunBegeni=" + urunBegeni + "]";
	}

	

}
