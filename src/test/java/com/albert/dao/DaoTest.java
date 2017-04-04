package com.albert.dao;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.albert.AppTest;


public class DaoTest extends AppTest{
	@Autowired  
	DictionaryDao dao;
	@Test
	public void test(){
		Assert.assertSame(2,dao.count());
	}
}
