package com.albert.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.albert.domain.RestEntity;
import com.albert.domain.table.Book;
import com.albert.domain.view.QueryBook;
import com.albert.service.BookService;
import com.albert.service.CommonService;
import com.albert.utils.BookException;
import com.albert.utils.ConvertSqlByForm;
import com.albert.utils.Page;
import com.albert.utils.RequestMap;

@RestController
@RequestMapping("/book")
public class BookController extends BaseController {
	
	@Resource
	private CommonService commonService;
	@Resource
	private BookService bookService;
	@RequestMapping(value = "/{bookId}",method={RequestMethod.GET})
	public RestEntity getBook(@PathVariable Long bookId,HttpServletRequest request) {
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
	public RestEntity deleteBook(@PathVariable Long bookId){
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
	public RestEntity updateBook(Book book) {
		try {
			bookService.update(book);
			return RestEntity.success(book);
		} catch (BookException e) {
			e.printStackTrace();
			return RestEntity.failed(e.getMessage());
		}
	}
	@RequestMapping(value = "/list")
	public RestEntity list(HttpServletRequest request,Integer page,Integer size){
		try {
			RequestMap map = getRequestMap(request);
			ConvertSqlByForm.convert(map);
			if(size==null){
				page = Page.MAX_PAGE;
				size = Page.MAX_SIZE;
			}
			Page<QueryBook> pages = commonService.findPage(QueryBook.class, new Page<QueryBook>(page, size,new Sort(Direction.DESC, "credate"),map));
			return RestEntity.success(pages);
		} catch (BookException e) {
			e.printStackTrace();
			return RestEntity.failed(e.getMessage());
		}
	}
	@RequestMapping(value="/save",method={RequestMethod.POST})
	public RestEntity save(Book book){
		System.out.println("访问");
		System.out.println(book);
		return RestEntity.success();
	}
	
	public BookService getBookService() {
		return bookService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
}
