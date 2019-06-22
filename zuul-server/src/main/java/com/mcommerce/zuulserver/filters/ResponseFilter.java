package com.mcommerce.zuulserver.filters;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ResponseFilter extends ZuulFilter {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Override
	public Object run() throws ZuulException {
		HttpServletResponse rep = RequestContext.getCurrentContext().getResponse();
//		logger.info("Le statut de la reponse avant modif est {} ", rep.getStatus());
//		rep.setStatus(400);
		logger.info("Le statut final de la reponse est {} ", rep.getStatus());
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
		
		return "post";
	}

}
