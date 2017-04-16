package com.albert.domain.view;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.albert.domain.EntityBase;
@Entity
@Table(name="vw_query_book")
public class QueryBook implements EntityBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = -88022199612313642L;
	@Id
	private Long id;
	
	private Long typeid;
	
	private String name;
	
	private String credate;
	
	private Double val;
	
	private Integer orderby;
	
	private String icon;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public Double getVal() {
		return val;
	}

	public void setVal(Double val) {
		this.val = val;
	}

	public Integer getOrderby() {
		return orderby;
	}

	public void setOrderby(Integer orderby) {
		this.orderby = orderby;
	}

	public Long getTypeid() {
		return typeid;
	}

	public void setTypeid(Long typeid) {
		this.typeid = typeid;
	}

	public String getCredate() {
		return credate;
	}

	public void setCredate(String credate) {
		this.credate = credate;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

}
