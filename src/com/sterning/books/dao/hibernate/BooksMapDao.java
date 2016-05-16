package com.sterning.books.dao.hibernate;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sterning.books.dao.iface.BooksDao;
import com.sterning.books.model.Books;
import com.sterning.commons.PublicUtil;

/**
 * @author cwf
 * 
 */
public class BooksMapDao extends HibernateDaoSupport implements BooksDao {

	public BooksMapDao() {
	}

	/**
	 * ����˵�������Ϣ ����˵����� ����ֵ��
	 */
	public void addBook(Books book) {
		this.getHibernateTemplate().save(book);
	}

	/**
	 * ����˵��ɾ����Ϣ ����˵�� ���� ����ֵ��
	 */
	public void deleteBook(Books book) {
		if (null != book) {
			this.getHibernateTemplate().delete(book);
		}
	}

	/**
	 * ����˵�������е���Ϣ ����˵�� ����ֵ����Ϣ�ļ���
	 */
	public List getAll() {
		String sql = "FROM Books ORDER BY id";
		return this.getHibernateTemplate().find(sql);
	}

	/**
	 * ����˵���������� ����˵�� ����ֵ��������
	 */
	public int getRows() {
		String sql = "FROM Books ORDER BY id";
		List list = this.getHibernateTemplate().find(sql);
		return list.size();
	}

	/**
	 * ����˵�������е���Ϣ ����˵�� ����ֵ����Ϣ�ļ���
	 */
	public List getBooks(int pageSize, int startRow) throws HibernateException {
		final int pageSize1 = pageSize;
		final int startRow1 = startRow;
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {

			public List doInHibernate(Session session) throws HibernateException, SQLException {
				// TODO �Զ���ɷ������
				Query query = session.createQuery("FROM Books ORDER BY id");
				query.setFirstResult(startRow1);
				query.setMaxResults(pageSize1);
				return query.list();
			}
		});
	}

	/**
	 * ����˵����һ�����Ϣ ����˵�� ID ����ֵ������
	 */
	public Books getBook(String id) {
		return (Books) this.getHibernateTemplate().get(Books.class, id);
	}

	/**
	 * ����˵�������ID ����˵�� ����ֵ�����ID
	 */
	public String getMaxID() {
		String date = PublicUtil.getStrNowDate();
		String sql = "SELECT MAX(id)+1 FROM Books  ";
		String noStr = null;
		List ll = (List) this.getHibernateTemplate().find(sql);
		Iterator itr = ll.iterator();
		if (itr.hasNext()) {
			Object noint = itr.next();
			if (noint == null) {
				noStr = "1";
			} else {
				noStr = noint.toString();
			}
		}

		if (noStr.length() == 1) {
			noStr = "000" + noStr;
		} else if (noStr.length() == 2) {
			noStr = "00" + noStr;
		} else if (noStr.length() == 3) {
			noStr = "0" + noStr;
		} else {
			noStr = noStr;
		}
		return noStr;
	}

	/**
	 * ����˵���޸���Ϣ ����˵�� ���� ����ֵ��
	 */
	public void updateBook(Books pd) {
		this.getHibernateTemplate().update(pd);
	}

	/**
	 * ����˵���ѯ��Ϣ ����˵�� ���� ����ֵ��
	 */
	public List queryBooks(String fieldname, String value) {
		System.out.println("value: " + value);
		String sql = "FROM Books where " + fieldname + " like '%" + value + "%'" + "ORDER BY id";

		return this.getHibernateTemplate().find(sql);
	}

	/**
	 * ����˵���������� ����˵�� ����ֵ��������
	 */
	public int getRows(String fieldname, String value) {
		String sql = "";
		if (fieldname == null || fieldname.equals("") || fieldname == null || fieldname.equals(""))
			sql = "FROM Books ORDER BY bookId";
		else
			sql = "FROM Books where " + fieldname + " like '%" + value + "%'" + "ORDER BY id";
		List list = this.getHibernateTemplate().find(sql);
		return list.size();
	}

	/**
	 * ����˵���ѯ��Ϣ ����˵�� ���� ����ֵ��
	 */
	public List getBooks(String fieldname, String value, int pageSize, int startRow) {
		final int pageSize1 = pageSize;
		final int startRow1 = startRow;
		final String queryName = fieldname;
		final String queryValue = value;

		String sql = "";

		if (queryName == null || queryName.equals("") || queryValue == null || queryValue.equals(""))
			sql = "FROM Books ORDER BY id";
		else
			sql = "FROM Books where " + fieldname + " like '%" + value + "%'" + "ORDER BY id";

		final String sql1 = sql;
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {

			public List doInHibernate(Session session) throws HibernateException, SQLException {
				// TODO �Զ���ɷ������
				Query query = session.createQuery(sql1);
				query.setFirstResult(startRow1);
				query.setMaxResults(pageSize1);
				return query.list();
			}
		});
	}
}