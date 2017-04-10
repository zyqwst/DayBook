package com.albert.dao;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.albert.AppTest;
import com.albert.domain.table.Book;
import com.albert.utils.BookException;
import com.albert.utils.Page;


public class DaoTest extends AppTest{
	@Autowired  
	CommonDao dao;
	@Test
	public void test(){
		Page<Book> page = new Page<Book>(0, 1);
		try {
			Page<Book> list = dao.findPage(Book.class, page);
			System.out.println(list.getResults());
		} catch (BookException e) {
			e.printStackTrace();
		}
	}
}
