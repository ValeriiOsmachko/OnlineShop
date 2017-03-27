package com.epam.osmachko.sequrity;

import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;

import com.epam.osmachko.bean.SequrityBean;
import com.epam.osmachko.entity.User;

public class SequrityConstraintChecker {

	private SequrityBeanContainer list;
	
	private HttpSession session;
	public SequrityConstraintChecker(SequrityBeanContainer container,HttpSession session) {
		this.list = container;
		this.session = session;
		
	}
	
	
	public boolean isRequestedResourceAviableForCurrentUser(String URI) {
		User user = (User) session.getAttribute("logUser");
		for(SequrityBean element : list.getList()) {
			if(Pattern.compile(element.getURL()).matcher(URI).matches()) {
				List<String> list1 = element.getRoles();
				for(String element1 : list1) {
					if(element1.equals(user.getRole())) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	
	
	public boolean isRequestedURLHasLimitedAccess(String URI) {
		for(SequrityBean element : list.getList()) {
			if(Pattern.compile(element.getURL()).matcher(URI).matches()) {
				return true;
			}
		}
		return false;
	}
	
	
	public boolean isUserLoggedIn() {
		return session.getAttribute("logUser") != null;
		
	}
	
	
}
