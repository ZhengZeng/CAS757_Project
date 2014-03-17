package edu.mcm.cas757.model;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public class BaseCriteria {
	private final static int DEFAULT_PAGESIZE = 6;

	private int page;
	private int pageSize;
	private String queryString;
	private String countQueryString;
	private String sortBy;
	private String sortDir;
	private Map<String, Object> params;

	public BaseCriteria() {
		pageSize = DEFAULT_PAGESIZE; // make a default page size
		params = new HashMap<String, Object>();
	}

	public Map<String, Object> getParams() {
		return params;
	}

	public void setParams(Map<String, Object> param) {
		this.params = param;
	}
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getQueryString() {
		return queryString;
	}

	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}

	public String getCountQueryString() {
		if (StringUtils.isEmpty(countQueryString)
				&& StringUtils.isNotEmpty(queryString))
			return "select count(*) ".concat(queryString);
		return countQueryString;
	}

	public void setCountQueryString(String countQueryString) {
		this.countQueryString = countQueryString;
	}

	public String getSortBy() {
		return sortBy;
	}

	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}

	public String getSortDir() {
		return sortDir;
	}

	public void setSortDir(String sortDir) {
		this.sortDir = sortDir;
	}

	public void clear() {
		this.page = 1;
		this.pageSize = DEFAULT_PAGESIZE;
		this.queryString = null;
		this.countQueryString = null;
		this.sortBy = null;
		this.sortDir = null;
		this.params.clear();
	}
}
