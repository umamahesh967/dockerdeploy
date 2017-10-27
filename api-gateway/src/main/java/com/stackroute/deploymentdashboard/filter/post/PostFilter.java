package com.stackroute.deploymentdashboard.filter.post;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

public class PostFilter extends ZuulFilter {
    private static Logger log = LoggerFactory.getLogger(PostFilter.class);

    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 2;
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
    			System.out.println("............Post filter executed...."+request.getRequestURI()+"...."+IOUtils.toString(request.getReader()));
    		}catch (IOException e) {
    			e.printStackTrace();
    		}
    	}
    	if(request.getMethod().equalsIgnoreCase("get")) {
    		System.out.println("............Post filter executed...."+request.getRequestURI());
    	}
        return null;
    }
}