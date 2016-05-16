package com.sterning.books.web.actions;

import java.util.Collection;

import com.sterning.books.model.Books;
import com.sterning.books.services.iface.IBooksService;
import com.sterning.commons.AbstractAction;
import com.sterning.commons.Pager;
import com.sterning.commons.PagerService;


public class BooksAction extends AbstractAction {
	
	private IBooksService booksService;
	private PagerService pagerService;
	
	private Books book;
	private Pager pager;
	
	protected Collection availableItems;
	protected String currentPage;
	protected String pagerMethod;
	protected String totalRows;
	protected String id;
	protected String queryName;
	protected String queryValue;
	protected String searchName;
	protected String searchValue;
	protected String queryMap;
	
	public String list() throws Exception {
		if(queryMap ==null||queryMap.equals("")){
			
		}else{
			String[] str=queryMap.split("~");
			this.setQueryName(str[0]);
			this.setQueryValue(str[1]);
		}
		
		System.out.println("asd"+this.getQueryValue());
		int totalRow=booksService.getRows(this.getQueryName(),this.getQueryValue());
		pager=pagerService.getPager(this.getCurrentPage(), this.getPagerMethod(), totalRow);
		this.setCurrentPage(String.valueOf(pager.getCurrentPage()));
		this.setTotalRows(String.valueOf(totalRow));
		availableItems=booksService.getBooks(this.getQueryName(),this.getQueryValue(),pager.getPageSize(), pager.getStartRow());
		
		this.setQueryName(this.getQueryName());
		this.setQueryValue(this.getQueryValue());
		
		this.setSearchName(this.getQueryName());
		this.setSearchValue(this.getQueryValue());
		
		return SUCCESS;		 
	}
	
	public String load() throws Exception {
		if(id!=null)
			book = booksService.getBook(id);
		else
			id=booksService.getMaxID();
	    return SUCCESS;
	}
	
	public String save() throws Exception {
		
		String id=this.getBook().getId();
		Books book=booksService.getBook(id);
		
		
		
		if(book == null)
			booksService.addBook(this.getBook());
		else
			booksService.updateBook(this.getBook());
		
		this.setQueryName(this.getQueryName());
		this.setQueryValue(this.getQueryValue());
		
		if(this.getQueryName()==null||this.getQueryValue()==null||this.getQueryName().equals("")||this.getQueryValue().equals("")){
			
		}else{
			queryMap=this.getQueryName()+"~"+this.getQueryValue();
		}
		
		
	    return SUCCESS;
	}
	
	public String delete() throws Exception {
		booksService.deleteBook(this.getId());
		
		if(this.getQueryName()==null||this.getQueryValue()==null||this.getQueryName().equals("")||this.getQueryValue().equals("")){
			
		}else{
			queryMap=this.getQueryName()+"~"+this.getQueryValue();
		}
		return SUCCESS;
	}
	
	
	public Books getBook() {
		return book;
	}

	public void setBook(Books book) {
		this.book = book;
	}

	public IBooksService getBooksService() {
		return booksService;
	}

	public void setBooksService(IBooksService booksService) {
		this.booksService = booksService;
	}

	public Collection getAvailableItems() {
        return availableItems;
    }


	public String getCurrentPage() {
		return currentPage;
	}


	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}


	public String getPagerMethod() {
		return pagerMethod;
	}


	public void setPagerMethod(String pagerMethod) {
		this.pagerMethod = pagerMethod;
	}


	public Pager getPager() {
		return pager;
	}


	public void setPager(Pager pager) {
		this.pager = pager;
	}

	public String getTotalRows() {
		return totalRows;
	}


	public void setTotalRows(String totalRows) {
		this.totalRows = totalRows;
	}
		
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getQueryName() {
		return queryName;
	}

	public void setQueryName(String queryName) {
		this.queryName = queryName;
	}

	public String getQueryValue() {
		return queryValue;
	}

	public void setQueryValue(String queryValue) {
		this.queryValue = queryValue;
	}
	
	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	public String getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}
	
	public String getQueryMap() {
		return queryMap;
	}

	public void setQueryMap(String queryMap) {
		this.queryMap = queryMap;
	}
	
	public PagerService getPagerService() {
		return pagerService;
	}


	public void setPagerService(PagerService pagerService) {
		this.pagerService = pagerService;
	}

	
}
