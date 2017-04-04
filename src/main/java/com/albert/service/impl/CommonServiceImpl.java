package com.albert.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.albert.dao.CommonDao;
import com.albert.domain.EntityBase;
import com.albert.service.CommonService;
import com.albert.utils.BookException;

@Service
public class CommonServiceImpl implements CommonService{
	@Resource
	private  CommonDao  commonDao;

	@Override
	public <T extends EntityBase> void save(T t) throws BookException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <T extends EntityBase> void update(T t) throws BookException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) throws BookException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <T extends EntityBase> T findEntityById(Class<T> clazz, Long id) throws BookException {
		return commonDao.findEntityById(clazz, id);
	}

	@Override
	public <T extends EntityBase> T findEntity(String hql, List<Object> params) throws BookException {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
