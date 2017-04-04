package com.albert.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.albert.domain.table.Dictionary;
import com.albert.service.CommonService;
import com.albert.utils.BookException;

@RestController
@RequestMapping("/book")
public class BookController extends BaseController {
	
	@Resource
	private CommonService commonService;
	
	@RequestMapping(value = "/{bookId}",method={RequestMethod.GET})
	public String book(@PathVariable Long bookId){
		try {
			return "book"+commonService.findEntityById(Dictionary.class,bookId);
		} catch (BookException e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
	
}
