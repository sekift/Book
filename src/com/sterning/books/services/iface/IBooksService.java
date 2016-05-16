package com.sterning.books.services.iface;

import java.util.List;

import com.sterning.books.model.Books;

public interface IBooksService {
	
	List getAll();// ������м�¼

	List getBooks(int pageSize, int startRow);// ������м�¼

	int getRows();// ���������

	int getRows(String fieldname, String value);// ���������

	List queryBooks(String fieldname, String value);// ��������ѯ

	List getBooks(String fieldname, String value, int pageSize, int startRow);// ��������ѯ

	Books getBook(String id);// ���ID��ü�¼

	String getMaxID();// ������IDֵ

	void addBook(Books pd);// ��Ӽ�¼

	void updateBook(Books pd);// �޸ļ�¼

	void deleteBook(String id);// ɾ���¼

}
