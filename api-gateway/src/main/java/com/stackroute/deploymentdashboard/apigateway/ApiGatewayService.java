package com.stackroute.deploymentdashboard.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.stackroute.deploymentdashboard.apigateway.filter.error.ErrorFilter;
import com.stackroute.deploymentdashboard.apigateway.filter.post.PostFilter;
import com.stackroute.deploymentdashboard.apigateway.filter.pre.PreFilter;
import com.stackroute.deploymentdashboard.apigateway.filter.router.RouterFilter;


@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class ApiGatewayService 
{

    public static void main(String[] args) 
    {
        SpringApplication.run(ApiGatewayService.class, args);
    }
    
    
    @Bean
    public PreFilter preFilter() {
        return new PreFilter();
    }
	
	@Bean
    public PostFilter postFilter() {
        return new PostFilter();
    }
	
	@Bean
    public RouterFilter routerFilter() {
        return new RouterFilter();
    }
	
	@Bean
    public ErrorFilter errorFilter() {
        return new ErrorFilter();
    }
}

