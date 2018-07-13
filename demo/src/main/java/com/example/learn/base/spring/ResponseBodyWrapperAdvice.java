package com.example.learn.base.spring;

import com.example.learn.base.dto.BaseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * Created by tuofan on 2018-7-11.
 *
 */

@ControllerAdvice
public class ResponseBodyWrapperAdvice implements ResponseBodyAdvice<Object> {
	private static final Logger log = LoggerFactory.getLogger(ResponseBodyWrapperAdvice.class);

	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
		return true;
	}

	@Override
	public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
			Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
			ServerHttpResponse response) {
		if(!returnType.getMethod().getDeclaringClass().getName().startsWith("com.example")) {
			return body;
		}
		BaseResult r = new BaseResult();
		r.setErrCode("0");
		r.setData(body);
		return r;
	}
}
