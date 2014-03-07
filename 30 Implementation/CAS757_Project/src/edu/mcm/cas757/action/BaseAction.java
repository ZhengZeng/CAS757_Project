package edu.mcm.cas757.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import edu.mcm.cas757.service.ServiceLocator;

@SuppressWarnings("serial")
public class BaseAction extends ActionSupport implements 
ServletRequestAware,ServletResponseAware,SessionAware{
	    protected HttpServletRequest request;
	    protected HttpServletResponse response;
	    protected Map<String, Object> session;
	    protected ServiceLocator serviceLocator;
	    
		public void setServiceLocator(ServiceLocator serviceLocator) {
			this.serviceLocator = serviceLocator;
		}

		@Override
		public void setServletRequest(HttpServletRequest arg0) {
			// TODO Auto-generated method stub
			this.request=arg0;
		}

		@Override
		public void setServletResponse(HttpServletResponse arg0) {
			// TODO Auto-generated method stub
			this.response=arg0;
		}

		@Override
		public void setSession(Map<String, Object> arg0) {
			// TODO Auto-generated method stub
			this.session=arg0;
		}

}
