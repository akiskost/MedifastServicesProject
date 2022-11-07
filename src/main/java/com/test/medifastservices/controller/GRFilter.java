package com.test.medifastservices.controller;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;


@WebFilter("/*")
public class GRFilter extends HttpFilter implements Filter {
       
	private static final long serialVersionUID = 1L;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {

	}

}
