package com.albert.service.impl;


import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.albert.dao.CommonDao;
import com.albert.domain.table.Book;
import com.albert.service.BookService;
import com.albert.utils.BookException;
@Service
@Transactional
public class BookServiceImpl implements BookService {
	@Resource
	private  CommonDao  commonDao;
	@Override
	public void update(Book book) throws BookException {
		try {
			commonDao.deleteById(Book.class, book.getId());
			book.setId(null);
			commonDao.save(book);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BookException(e.getMessage());
		}
	}
	public CommonDao getCommonDao() {
		return commonDao;
	}
	public void setCommonDao(CommonDao commonDao) {
		this.commonDao = commonDao;
	}

}
