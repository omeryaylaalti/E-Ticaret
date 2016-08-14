package com.eticaretforsalesite.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="yetki")
public class YetkiBean {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "yetkiID")
	private String yetkiID;
	@Column(name = "yetkiName")
	private String yetkiName;

	public String getYetkiID() {
		return yetkiID;
	}

	public void setYetkiID(String yetkiID) {
		this.yetkiID = yetkiID;
	}

	public String getYetkiName() {
		return yetkiName;
	}

	public void setYetkiName(String yetkiName) {
		this.yetkiName = yetkiName;
	}

	@Override
	public String toString() {
		return "YetkiBean [yetkiID=" + yetkiID + ", yetkiName=" + yetkiName + "]";
	}

	public YetkiBean(String yetkiID, String yetkiName) {
		this.yetkiID = yetkiID;
		this.yetkiName = yetkiName;
	}

	public YetkiBean() {
		super();
	}

}
