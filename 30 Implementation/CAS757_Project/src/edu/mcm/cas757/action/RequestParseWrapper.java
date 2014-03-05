package edu.mcm.cas757.action;

import org.apache.struts2.dispatcher.multipart.JakartaMultiPartRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


public class RequestParseWrapper extends JakartaMultiPartRequest {
    @Override
	public void parse(HttpServletRequest servletRequest, String saveDir)throws IOException {
    }
}
