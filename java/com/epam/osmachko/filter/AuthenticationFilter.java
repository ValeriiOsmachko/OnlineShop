package com.epam.osmachko.filter;

import java.io.IOException;


import java.util.List;
import java.util.Objects;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epam.osmachko.bean.SequrityBean;
import com.epam.osmachko.constant.Constant;
import com.epam.osmachko.custom_request_wrapper.StatusExposingServletResponse;
import com.epam.osmachko.entity.User;
import com.epam.osmachko.sequrity.SequrityBeanContainer;
import com.epam.osmachko.sequrity.SequrityConstraintChecker;
public class AuthenticationFilter implements Filter{

	private ServletContext ctx;
	
	private SequrityBeanContainer container;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		ctx = filterConfig.getServletContext();
		container = (SequrityBeanContainer) ctx.getAttribute(Constant.LIST_SEQURITY_BEANS);
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		HttpSession session = httpServletRequest.getSession(false);
		String URI = httpServletRequest.getRequestURI();
		SequrityConstraintChecker checker = new SequrityConstraintChecker(container,session);
		User logUser = null;
		if(checker.isRequestedURLHasLimitedAccess(URI)) {
				if(checker.isUserLoggedIn()) {
					if(checker.isRequestedResourceAviableForCurrentUser(URI)) {
						chain.doFilter(httpServletRequest, httpServletResponse);
					} else {
						httpServletResponse.sendError(403);
					}
					
				} else {
					httpServletResponse.sendRedirect(Constant.START_PAGE);
				}
		} else {
			chain.doFilter(httpServletRequest, httpServletResponse);
		}
	}

	@Override
	public void destroy() {
		
	}

}
