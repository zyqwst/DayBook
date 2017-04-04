package com.albert.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.albert.domain.RestEntity;
import com.albert.domain.table.Book;
import com.albert.service.CommonService;
import com.albert.utils.BookException;

@RestController
@RequestMapping("/book")
public class BookController extends BaseController {
	
	@Resource
	private CommonService commonService;
	
	@RequestMapping(value = "/{bookId}",method={RequestMethod.GET})
	public RestEntity book(@PathVariable Long bookId){
		try {
			if(bookId == null) throw new BookException("bookid不可为空");
			Book b = commonService.findEntityById(Book.class, bookId);
			return RestEntity.success(b);
		} catch (BookException e) {
			e.printStackTrace();
			return RestEntity.failed(e.getMessage());
		}
	}
	
}
