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

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;



@Component
public class SimpleCORSFilter implements Filter {

	@Value("${CORS_ORIGIN}")
	private String corsOrgin;

	public static final String NO_CACHE="no-cache";

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;

		
		        request.getHeader("Origin");
		request.getHeader("HTTP_X_FORWARDED_FOR");
		req.getRemoteAddr();
		req.getRemoteHost();
		req.getParameterMap();
		HttpMethod.OPTIONS.matches(request.getMethod());
		request.getHeader(HttpHeaders.ACCESS_CONTROL_REQUEST_METHOD);
		response.setHeader("Access-Control-Allow-Origin","https://es-staging.cdac.in" );
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Allow-Methods", "POST,GET,PUT,OPTIONS");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers",
				"Content-Type, Accept, X-Requested-With, remember-me,Authorization");
		response.setHeader("Cache-Control",
				"cache,no-store, must-revalidate,pre-check=0, post-check=0, max-age=0, s-maxage=0");
		//response.setHeader("Pragma", NO_CACHE);
		response.setDateHeader("expires", -1);
		//response.setHeader("Cache-directive", NO_CACHE);
		//response.setHeader("Pragma-directive", NO_CACHE);
		response.addHeader("x-frame-options", "deny");
		chain.doFilter(request, response);

		/*try {
			chain.doFilter(new XSSRequestWrapper((HttpServletRequest) request,response), response);
		} catch (Exception e) {
			if (e.getMessage() != null && e.getMessage().equalsIgnoreCase("Corrupted data passed")) {
				this.corruptedData(e.getMessage());
			}
		}*/

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

	/**
	 * Corrupted data.
	 *
	 * @param dataString
	 *            the data string
	 * @return the response entity
	 */
	/*private ResponseEntity<CustomResponse> corruptedData(String dataString) {
		CustomResponse customResponse = null;
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
		String description = dataString;

		customResponse = commonUtil.getCustomResponse(httpStatus, null, description);
		return new ResponseEntity<>(customResponse, httpStatus);
	}*/

}
