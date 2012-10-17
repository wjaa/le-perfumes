package br.com.wjaa.controller.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.wjaa.commons.model.entity.Usuario;

/**
 * Servlet Filter implementation class FiltroUsuario
 */
public class FiltroUsuario implements Filter {

    /**
     * Default constructor. 
     */
    public FiltroUsuario() {
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest r = (HttpServletRequest)request;

		Usuario usuario = (Usuario)r.getSession().getAttribute("usuario");
		
		if (usuario == null){
			HttpServletResponse rp = (HttpServletResponse)response;
			rp.sendRedirect("index.jsp");
		}else{
			chain.doFilter(request, response);
		}
		
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
