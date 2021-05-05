package filter;

import java.io.IOException;
import java.net.http.HttpRequest;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import store.GobalStore;

/**
 * Servlet Filter implementation class FilterDispatcher
 */
public class FilterDispatcher implements Filter {

	/**
	 * Default constructor.
	 */
	public FilterDispatcher() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest reg = (HttpServletRequest) request;
		String uri = reg.getRequestURI();
		String url = GobalStore.LOGIN_PAGE;

		try {
			int lastIndext = uri.lastIndexOf("/");
			String resource = uri.substring(lastIndext + 1);

			if (resource.length() > 0) {
				if (resource.lastIndexOf(".html") > 0 || resource.lastIndexOf(".jsp") > 0) {
					url = resource;
				} else if (resource.contains("login")) {
					 url = GobalStore.LOGIN_SERVLET;
				} else {
					url = resource.substring(0, 1).toUpperCase() + resource.substring(1) + "Servlet";
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			RequestDispatcher rd = reg.getRequestDispatcher(url);
			rd.forward(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
