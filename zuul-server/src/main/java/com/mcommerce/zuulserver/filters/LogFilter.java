package com.mcommerce.zuulserver.filters;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class LogFilter extends ZuulFilter {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Override
	public Object run() throws ZuulException {
		HttpServletRequest req = RequestContext.getCurrentContext().getRequest();
		logger.info("Requete interceptee : l'URL est {} ", req.getRequestURL());
		return null;
	}

	@Override
	public boolean shouldFilter() {
		
		return true;
	}

	@Override
	public int filterOrder() {
		
		return 0;
	}

	@Override
	public String filterType() {
		
		return "pre";
	}

}
