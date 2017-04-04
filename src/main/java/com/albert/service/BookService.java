package com.albert.service;


import com.albert.domain.table.Book;
import com.albert.utils.BookException;

public interface BookService {
	public void update(Book book) throws BookException;
}
