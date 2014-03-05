package edu.mcm.cas757.action;

public class Test extends BaseAction {

//	ActionContext ac = ActionContext.getContext();
//	ServletContext sc = (ServletContext) ac
//			.get(ServletActionContext.SERVLET_CONTEXT);
//	String temp = ServletActionContext.getRequest().getRealPath("/");
//	
	

	public void test() {
		String a = "fastJson的魅力!";
		super.writeJson(a);
	}

//    public static void main(String[] args) {
//        File = new File("e:\f.jpg");
//    }

}
