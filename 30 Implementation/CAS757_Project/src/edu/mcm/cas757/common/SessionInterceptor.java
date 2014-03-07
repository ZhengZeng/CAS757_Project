package edu.mcm.cas757.common;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

import edu.mcm.cas757.dao.entity.User;


public class SessionInterceptor extends MethodFilterInterceptor {

	private static final Logger logger = Logger.getLogger(SessionInterceptor.class);

	@Override
	protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
		User t = (User) ServletActionContext.getRequest().getSession().getAttribute("loginUser");
		if (t == null) {
			ServletActionContext.getRequest().getSession().setAttribute("actionUrl", RequestUtil.getRequestPath(ServletActionContext.getRequest()));
			ServletActionContext.getRequest().setAttribute("Message", "Session expired.");
			return "noSession";
		}
		return actionInvocation.invoke();
	}

}
