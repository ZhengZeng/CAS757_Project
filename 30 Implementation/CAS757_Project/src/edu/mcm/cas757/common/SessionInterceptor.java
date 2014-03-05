package edu.mcm.cas757.common;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

import edu.mcm.cas757.dao.entity.Tuser;


public class SessionInterceptor extends MethodFilterInterceptor {

	private static final Logger logger = Logger.getLogger(SessionInterceptor.class);

	@Override
	protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
		Tuser t = (Tuser) ServletActionContext.getRequest().getSession().getAttribute("loginUser");
		if (t == null) {
			ServletActionContext.getRequest().getSession().setAttribute("actionUrl", RequestUtil.getRequestPath(ServletActionContext.getRequest()));
			ServletActionContext.getRequest().setAttribute("msg", "您还没有登录或登录已超时，请重新登录，然后再刷新本功能！");
			return "noSession";
		}
		return actionInvocation.invoke();
	}

}
