package com.albert.domain.table;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.albert.domain.EntityBase;
@Entity
@Table(name="t_book")
public class Book implements EntityBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8088696606214103990L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Long typeid;
	
	private String credate;
	
	private Double val;
	

	@Override
	public String toString() {
		return "Book [id=" + id + ", typeid=" + typeid + ", credate=" + credate + ", val=" + val + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Double getVal() {
		return val;
	}

	public void setVal(Double val) {
		this.val = val;
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


}
