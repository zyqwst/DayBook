package com.albert.service;

import java.util.List;

import com.albert.domain.EntityBase;
import com.albert.utils.BookException;

public interface CommonService {
	public <T extends EntityBase> void save(T t) throws BookException;
	
	public <T extends EntityBase>  void update(T t) throws BookException;
	
	public void delete(Long id) throws BookException;
	
	public <T extends EntityBase> T findEntityById(Class<T> clazz,Long id) throws BookException;
	
	public <T extends EntityBase> T findEntity(String hql,List<Object> params) throws BookException;
}
