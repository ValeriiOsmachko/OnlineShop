package com.epam.osmachko.custom_tag;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class CaptchaTag extends SimpleTagSupport {

	
	public void doTag() throws JspException, IOException { 
		JspWriter out = getJspContext().getOut(); 
		PageContext pageContext = (PageContext) getJspContext(); 
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest(); 
		String argument = request.getServletContext().getInitParameter("Strategy"); 
		String uuid = ""; 
		StringBuilder builder = new StringBuilder(); 
		StringBuilder builder2 = new StringBuilder(); 
		if(!argument.equals("HiddenFieldStrategy")) { 
		builder.append("<img src='CaptchaServlet'>"); 
		builder.append(System.getProperty("line.separator")); 
		builder.append("<input type='text' name='captcha' class='text'>"); 
		} else { 
		uuid = generateUUID(); 
		request.getSession().setAttribute("uuid", uuid);
		builder.append("<input type='hidden' name='idCaptcha' value='"); 
		builder2.append("'>"); 
		builder2.append(System.getProperty("line.separator")); 
		builder2.append("<img src='CaptchaServlet'>"); 
		builder2.append(System.getProperty("line.separator")); 
		builder2.append("<input type='text' name='captcha' class='text'>"); 



		} 
		out.println(builder + uuid + builder2); 

		} 

		private String generateUUID() { 
		UUID uuid = UUID.randomUUID(); 
		return String.valueOf(uuid); 
		}
}
