package com.eticaretforsalesite.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Kategoriler")
public class Kategoriler {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "catName")
	private String cat_name;

	@Column(name = "status")
	private String status;

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "ustcatid")
	private Kategoriler ust_category;

	@OneToMany(mappedBy = "ust_category")
	private Set<Kategoriler> category = new HashSet<Kategoriler>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCat_name() {
		return cat_name;
	}

	public void setCat_name(String cat_name) {
		this.cat_name = cat_name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Kategoriler getUst_category() {
		return ust_category;
	}

	public void setUst_category(Kategoriler ust_category) {
		this.ust_category = ust_category;
	}

	public Set<Kategoriler> getCategory() {
		return category;
	}

	public void setCategory(Set<Kategoriler> category) {
		this.category = category;
	}

	public Kategoriler(String cat_name, String status) {
		super();
		this.cat_name = cat_name;
		this.status = status;
	}

	public Kategoriler() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Kategoriler(int id, String cat_name, String status, Kategoriler ust_category, Set<Kategoriler> category) {
		super();
		this.id = id;
		this.cat_name = cat_name;
		this.status = status;
		this.ust_category = ust_category;
		this.category = category;
	}

	@Override
	public String toString() {
		return "Kategoriler [id=" + id + ", cat_name=" + cat_name + ", status=" + status + ", ust_category="
				+ ust_category + "]";
	}

}
