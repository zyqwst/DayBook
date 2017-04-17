package com.albert.dao;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.albert.AppTest;
import com.albert.domain.table.Book;
import com.albert.domain.table.Dictionary;
import com.albert.utils.BookException;
import com.albert.utils.Page;


public class DaoTest extends AppTest{
	@Autowired  
	CommonDao dao;
	@Test
	public void test(){
		Page<Dictionary> page = new Page<Dictionary>(0, 1);
		try {
			Page<Dictionary> list = dao.findPage(Dictionary.class, page);
			System.out.println(list.getResults());
		} catch (BookException e) {
			e.printStackTrace();
		}
	}
}
