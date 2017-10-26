package com.stackroute.deploymentdashboard.apigateway.filter.router;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.http.HttpServletRequest;

public class RouterFilter  extends ZuulFilter{
	private static Logger log = LoggerFactory.getLogger(RouterFilter.class);

    @Override
    public String filterType() {
        return "route";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
//        RequestContext ctx = RequestContext.getCurrentContext();
//        HttpServletRequest request = ctx.getRequest();
//
//        log.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));
//        
    	System.out.println("Router filter");
        return null;
    }
	

}
