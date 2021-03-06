package com.example.gateway;

import brave.Tracer;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * This class is to add spring slethu's correlation id
 * into the http response header
 * Courtesy - Spring Microservices in Action
 */
@Component
public class GatewayResponseFilter extends ZuulFilter {
  private static final int FILTER_ORDER = 1;
  private static final boolean SHOULD_FILTER = true;
  private static final Logger logger = LoggerFactory.getLogger(GatewayResponseFilter.class);
  @Autowired
  Tracer tracer;

  @Override
  public String filterType() {
    return "post";
  }

  @Override
  public int filterOrder() {
    return FILTER_ORDER;
  }

  @Override
  public boolean shouldFilter() {
    return SHOULD_FILTER;
  }

  @Override
  public Object run() {
    RequestContext ctx = RequestContext.getCurrentContext();
    ctx.getResponse().addHeader("tmx-correlation-id", tracer.currentSpan().toString());
    return null;
  }
}
