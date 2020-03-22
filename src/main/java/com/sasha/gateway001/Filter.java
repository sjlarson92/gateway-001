package com.sasha.gateway001;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Filter extends ZuulFilter {

    private Logger logger = LoggerFactory.getLogger(Filter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {

        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest httpServletRequest = requestContext.getRequest();
        logger.info("{} request to {}", httpServletRequest.getMethod(), httpServletRequest.getRequestURL().toString());

        HttpServletResponse httpServletResponse = requestContext.getResponse();
        httpServletResponse.setHeader("Access-Control-Expose-Headers", "*");
        return null;
    }
}
