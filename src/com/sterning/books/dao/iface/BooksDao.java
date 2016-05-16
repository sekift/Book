package com.sterning.books.dao.iface;

import java.util.List;

import com.sterning.books.model.Books;

public interface BooksDao {

	List getAll();// 获得所有记录

	List getBooks(String fieldname, String value, int pageSize, int startRow);// 获得所有记录

	int getRows();// 获得总行数

	int getRows(String fieldname, String value);// 获得总行数

	List queryBooks(String fieldname, String value);// 根据条件查询

	Books getBook(String id);// 根据ID获得记录

	String getMaxID();// 获得最大ID值

	void addBook(Books book);// 添加记录

	void updateBook(Books book);// 修改记录

	void deleteBook(Books book);// 删除记录

	List getBooks(int pageSize, int startRow);

}
