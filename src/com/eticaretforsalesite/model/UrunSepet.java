package com.eticaretforsalesite.model;

public class UrunSepet {
	
	private String urunname;
    private int urunfiyat;
    private int urunadet;
    private String uruncategori;
	public String getUrunname() {
		return urunname;
	}
	public void setUrunname(String urunname) {
		this.urunname = urunname;
	}
	public int getUrunfiyat() {
		return urunfiyat;
	}
	public void setUrunfiyat(int urunfiyat) {
		this.urunfiyat = urunfiyat;
	}
	public int getUrunadet() {
		return urunadet;
	}
	public void setUrunadet(int urunadet) {
		this.urunadet = urunadet;
	}
	public String getUruncategori() {
		return uruncategori;
	}
	public void setUruncategori(String uruncategori) {
		this.uruncategori = uruncategori;
	}
	public UrunSepet() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UrunSepet(String urunname, int urunfiyat, int urunadet, String uruncategori) {
		super();
		this.urunname = urunname;
		this.urunfiyat = urunfiyat;
		this.urunadet = urunadet;
		this.uruncategori = uruncategori;
	}
	@Override
	public String toString() {
		return "UrunSepet [urunname=" + urunname + ", urunfiyat=" + urunfiyat + ", urunadet=" + urunadet
				+ ", uruncategori=" + uruncategori + "]";
	}
    
    

}
