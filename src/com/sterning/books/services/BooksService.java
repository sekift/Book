package com.sterning.books.services;

import java.util.List;

import com.sterning.books.model.Books;
import com.sterning.books.services.iface.IBooksService;
import com.sterning.books.dao.iface.BooksDao;

public class BooksService implements IBooksService{
	private BooksDao booksDao;
	
	public BooksService(){}
	
	/**
	 * ����˵�������Ϣ
	 * ����˵����� 
	 * ����ֵ��
	 */
	public void addBook(Books book) {
		booksDao.addBook(book);
	}

	/**
	 * ����˵��ɾ����Ϣ
	 * ����˵�� ����
	 * ����ֵ��
	 */
	public void deleteBook(String id) {
		Books book=booksDao.getBook(id);
		booksDao.deleteBook(book);
	}

	/**
	 * ����˵�������е���Ϣ
	 * ����˵�� 
	 * ����ֵ����Ϣ�ļ���
	 */
	public List getAll() {
		return booksDao.getAll();
	}
	
	/**
	 * ����˵����������
	 * ����˵�� 
	 * ����ֵ��������
	 */
	public int getRows() {
		return booksDao.getRows();
	}
	
	/**
	 * ����˵�������е���Ϣ
	 * ����˵�� 
	 * ����ֵ����Ϣ�ļ���
	 */
	public List getBooks(int pageSize, int startRow) {
		return booksDao.getBooks(pageSize, startRow);
	}

	/**
	 * ����˵����һ�����Ϣ
	 * ����˵�� ID
	 * ����ֵ������
	 */
	public Books getBook(String id) {
		return booksDao.getBook(id);
	}

	/**
	 * ����˵�������ID
	 * ����˵�� 
	 * ����ֵ�����ID
	 */
	public String getMaxID() {
		return booksDao.getMaxID();
	}

	/**
	 * ����˵���޸���Ϣ
	 * ����˵�� ����
	 * ����ֵ��
	 */
	public void updateBook(Books book) {
		booksDao.updateBook(book);
	}

	/**
	 * ����˵���ѯ��Ϣ
	 * ����˵�� ����
	 * ����ֵ��
	 */
	public List queryBooks(String fieldname,String value) {
		return booksDao.queryBooks(fieldname, value);
	}
	
	/**
	 * ����˵����������
	 * ����˵�� 
	 * ����ֵ��������
	 */
	public int getRows(String fieldname,String value) {
		return booksDao.getRows(fieldname, value);
	}
	
	/**
	 * ����˵���ѯ��Ϣ
	 * ����˵�� ����
	 * ����ֵ��
	 */
	public List getBooks(String fieldname,String value,int pageSize, int startRow) {
		return booksDao.getBooks(fieldname,value,pageSize,startRow);
	}

	public BooksDao getBooksDao() {
		return booksDao;
	}

	public void setBooksDao(BooksDao booksDao) {
		this.booksDao = booksDao;
	}


}
