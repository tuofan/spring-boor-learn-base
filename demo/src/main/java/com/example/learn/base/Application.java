package com.example.learn.base;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;

import java.util.Arrays;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public HttpMessageConverters fastJsonHttpMessageConverters() {
		FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setSerializerFeatures(new SerializerFeature[] { SerializerFeature.PrettyFormat,
				SerializerFeature.DisableCircularReferenceDetect });
		fastConverter.setFastJsonConfig(fastJsonConfig);
		fastConverter.setSupportedMediaTypes(Arrays.asList(new MediaType[] { MediaType.TEXT_PLAIN })); // MediaType.APPLICATION_JSON_UTF8
		return new HttpMessageConverters(new HttpMessageConverter[] { fastConverter });
	}
}
