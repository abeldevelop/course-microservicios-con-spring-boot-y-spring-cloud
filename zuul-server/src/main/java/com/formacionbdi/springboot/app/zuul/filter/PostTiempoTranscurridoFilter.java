package com.formacionbdi.springboot.app.zuul.filter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component
public class PostTiempoTranscurridoFilter extends ZuulFilter {

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		
		RequestContext requestContext = RequestContext.getCurrentContext();
		HttpServletRequest request = requestContext.getRequest();
		log.info("Entrando a post filter");
		Long tiempoInicio = (Long) request.getAttribute("tiempoInicio");
		Long tiempoFin = System.currentTimeMillis();
		Long tiempoTranscurrido = tiempoFin - tiempoInicio;
		
		log.info("Tiempo transcurrido en segundos: {}", (tiempoTranscurrido.doubleValue() / 1000.00));
		log.info("Tiempo transcurrido en milisegundos: {}", tiempoTranscurrido);
		return null;
	}

	@Override
	public String filterType() {
		return "post";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

	
	
}
