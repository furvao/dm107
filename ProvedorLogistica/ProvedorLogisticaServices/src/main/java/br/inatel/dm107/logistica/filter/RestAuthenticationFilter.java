package br.inatel.dm107.logistica.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.HttpHeaders;

public class RestAuthenticationFilter implements Filter{
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filter)
			throws IOException, ServletException {
		
		if(request instanceof HttpServletRequest){
			HttpServletRequest httpServletRequest = (HttpServletRequest) request;
			String authCredentials = httpServletRequest.getHeader(HttpHeaders.AUTHORIZATION);
			
			AuthenticationService authenticationService = new AuthenticationService();
			
			boolean authenticationStatus = 
                    authenticationService.authenticate(authCredentials);

            if (authenticationStatus) {
                filter.doFilter(request, response);
            } else {
                if (response instanceof HttpServletResponse) {
                    HttpServletResponse httpServletResponse = (HttpServletResponse) response;
                    httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                }
            }
		}
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}


}
