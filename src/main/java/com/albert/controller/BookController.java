package com.albert.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.albert.domain.RestEntity;
import com.albert.domain.table.Book;
import com.albert.domain.view.QueryBook;
import com.albert.service.BookService;
import com.albert.service.CommonService;
import com.albert.utils.BookException;
import com.albert.utils.Value;

@RestController
@RequestMapping("/book")
public class BookController extends BaseController {
	
	@Resource
	private CommonService commonService;
	@Resource
	private BookService bookService;
	@RequestMapping(value = "/{bookId}",method={RequestMethod.GET})
	public RestEntity getBook(@PathVariable Long bookId) throws BookException{
		try {
			if(bookId == null) throw new BookException("bookid不可为空");
			Book b = commonService.findEntityById(Book.class, bookId);
			return RestEntity.success(b);
		} catch (BookException e) {
			e.printStackTrace();
			return RestEntity.failed(e.getMessage());
		}
	}
	
	@RequestMapping(value = "/{bookId}",method={RequestMethod.DELETE})
	public RestEntity deleteBook(@PathVariable Long bookId) throws BookException{
		try {
			if(bookId == null) throw new BookException("bookid不可为空");
		    commonService.delete(Book.class,bookId);
			return RestEntity.success();
		} catch (BookException e) {
			e.printStackTrace();
			return RestEntity.failed(e.getMessage());
		}
	}
	@RequestMapping(value = "/update")
	public RestEntity updateBook(Book book) throws BookException{
		try {
			bookService.update(book);
			return RestEntity.success(book);
		} catch (BookException e) {
			e.printStackTrace();
			return RestEntity.failed(e.getMessage());
		}
	}
	@RequestMapping(value = "/list")
	public RestEntity list(Book book) throws BookException{
		try {
			List<QueryBook> list = commonService.findAll(QueryBook.class, " where credate=? ", new Value().add(book.getCredate()).getParams());
			return RestEntity.success(list);
		} catch (BookException e) {
			e.printStackTrace();
			return RestEntity.failed(e.getMessage());
		}
	}
	
	public BookService getBookService() {
		return bookService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
}
