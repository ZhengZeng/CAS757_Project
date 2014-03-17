package edu.mcm.cas757.model;

import java.util.List;

import org.displaytag.pagination.PaginatedList;
import org.displaytag.properties.SortOrderEnum;

public class PageDataModel<T> implements PaginatedList {
	private List<T> pdata;
	private int resultSize;
	private int currentPage;
	private int pageSize;
	private String searchId;
	private String sortCriterion;
	private SortOrderEnum sortDirection;

	public PageDataModel(BaseCriteria criteria) {
		super();
		this.currentPage = criteria.getPage();
		this.pageSize = criteria.getPageSize();
		this.sortCriterion = criteria.getSortBy();
		this.sortDirection = ("asc".equalsIgnoreCase(criteria.getSortDir()) ? SortOrderEnum.ASCENDING
				: SortOrderEnum.DESCENDING);
	}

	@Override
	public int getFullListSize() {
		return resultSize;
	}

	@Override
	public List<T> getList() {
		return pdata;
	}

	@Override
	public int getObjectsPerPage() {
		return pageSize;
	}

	@Override
	public int getPageNumber() {
		return currentPage;
	}

	@Override
	public String getSearchId() {
		return searchId;
	}

	@Override
	public String getSortCriterion() {
		return sortCriterion;
	}

	@Override
	public SortOrderEnum getSortDirection() {
		return sortDirection;
	}

	public void setResultSize(int resultSize) {
		this.resultSize = resultSize;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setSearchId(String searchId) {
		this.searchId = searchId;
	}

	public void setSortCriterion(String sortCriterion) {
		this.sortCriterion = sortCriterion;
	}

	public void setSortDirection(SortOrderEnum sortDirection) {
		this.sortDirection = sortDirection;
	}

	public void setPageData(List<T> pdata) {
		this.pdata = pdata;
	}

}
