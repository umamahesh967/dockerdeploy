package com.stackroute.deploymentdashboard.filter.router;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;



import javax.servlet.http.HttpServletRequest;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import javax.servlet.http.HttpServletRequest;

public class RouterFilter  extends ZuulFilter{
	private static Logger log = LoggerFactory.getLogger(RouterFilter.class);

    @Override
    public String filterType() {
        return "route";
    }

    @Override
    public int filterOrder() {
        return 3;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
    	
    	RequestContext ctx= RequestContext.getCurrentContext();
    	HttpServletRequest request=ctx.getRequest();
    	if(request.getMethod().equalsIgnoreCase("post")) {
    		System.out.println("............ROuter filter executed...."+request.getRequestURI()+"....");
    	}
    	if(request.getMethod().equalsIgnoreCase("get")) {
    		System.out.println("............Router filter executed...."+request.getRequestURI());
    	}
    	
        return null;
    }
	

}
