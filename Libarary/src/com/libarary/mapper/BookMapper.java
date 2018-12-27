package com.libarary.mapper;

import java.util.List;

import com.libarary.model.Book;
import com.libarary.po.BookVo;
import com.libarary.po.ComQuery;
import com.libarary.po.SimpleQuery;

public interface BookMapper {
	public void addBook(Book book) throws Exception;
	public List<Book> simpleQuery(SimpleQuery simpleQuery) throws Exception;
	public List<Book> comQuery(ComQuery comQuery) throws Exception;
	public List<Book> bookQuery(BookVo bookVo) throws Exception;
	public void deleteById(int bkID) throws Exception;
	public Book selectById(int bkID) throws Exception;
	public void updateBook(Book book) throws Exception;
}
