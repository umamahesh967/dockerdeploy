package com.stackroute.deploymentdashboard.filter.router;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
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
    		try{
    			System.out.println("............ROuter filter executed...."+request.getRequestURI()+"...."+IOUtils.toString(request.getReader()));
    		}catch (IOException e) {
    			e.printStackTrace();
    		}
    	}
    	if(request.getMethod().equalsIgnoreCase("get")) {
    		System.out.println("............Router filter executed...."+request.getRequestURI());
    	}
    	
        return null;
    }
	

}
