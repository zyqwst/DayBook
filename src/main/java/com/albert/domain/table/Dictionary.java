/**
 * 
 */
package com.albert.domain.table;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.albert.domain.EntityBase;

/**
 * @author Administrator
 *	数据字典
 */
@Entity
@Table(name="t_dictionary")
public class Dictionary implements EntityBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	private Integer status;
	public Dictionary() {
	}

	public Dictionary(String name,Integer status) {
		this.name = name;
		this.status = status;
	}
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Dictionary [id=" + id + ", name=" + name + ", status=" + status + "]";
	}
	
	
}
