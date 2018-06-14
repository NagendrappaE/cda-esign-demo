package com.evolvus.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

@Component
public class FluxFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest httpReq = (HttpServletRequest) req;
		HttpServletResponse httpsRes = (HttpServletResponse) res;
		
		httpsRes.addHeader("Access-Control-Allow-Origin","https://es-staging.cdac.in");
		//httpsRes.addHeader("Access-Control-Allow-Credentials","true");
		httpsRes.addHeader("Access-Control-Allow-Methods","GET,POST,OPTIONS");
		httpsRes.addHeader("Access-Control-Allow-Headers","Origin, X-Requested-With, Content-Type, Accept");
		
		chain.doFilter(req, res);

		// tter:off
	 
		// @formatter:on

		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
