package com.assignment.entity;

import javax.persistence.*;

@Entity
@Table
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long pid;
	@Column(name = "pname", length = 50)
	private String pname;
	@Column(name = "cat", length = 50)
	private String cat;
	@Column(name = "price", length = 50)
	private long price;
	@Column(name = "type", length = 50)
	private String type;

	public long getPid() {
		return pid;
	}

	public void setPid(long pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCat() {
		return cat;
	}

	public void setCat(String cat) {
		this.cat = cat;
	}

	public Product(long pid, String pname, String cat, long price, String type) {
		this.pid = pid;
		this.pname = pname;
		this.cat = cat;
		this.price = price;
		this.type = type;
	}

	public Product() {
	}

}
