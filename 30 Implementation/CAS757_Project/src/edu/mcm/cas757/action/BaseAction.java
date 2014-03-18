package edu.mcm.cas757.action;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import edu.mcm.cas757.model.BaseCriteria;
import edu.mcm.cas757.service.ServiceLocator;

@SuppressWarnings("serial")
public class BaseAction extends ActionSupport implements RequestAware,SessionAware{
	    private Map<String, Object> request;
	    protected HttpServletResponse response;
	    protected Map<String, Object> session;
	    protected ServiceLocator serviceLocator;
		protected int page = 1;
		protected String sort;
	    
		public int getPage() {
			return page;
		}

		public void setPage(int page) {
			this.page = page;
		}

		public String getSort() {
			return sort;
		}

		public void setSort(String sort) {
			this.sort = sort;
		}

		public void setServiceLocator(ServiceLocator serviceLocator) {
			this.serviceLocator = serviceLocator;
		}

		public void setRequest(Map<String, Object> request) {
			this.request = request;
		}

		public void setSession(Map<String, Object> arg0) {
			this.session=arg0;
		}

		protected Map<String, Object> getSession() {
			return this.session;
		}
		
		protected Map<String, Object> getRequest() {
			return this.request;
		}
		
		protected void initCriteria(BaseCriteria criteria) {
			criteria.setPage(this.getPage());
			criteria.setSortBy(this.getSort());
		}
}
