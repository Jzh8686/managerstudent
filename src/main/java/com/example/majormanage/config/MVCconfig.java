package com.example.majormanage.config;


import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.example.majormanage.component.LoginHandlerInterceptor;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * spring boot 2.x 后WebMvcConfigurerAdaper已经失效
 * 可以用WebMvcConfigurer和WebMvcConfigurationSupport代替
 * WebMvcConfigurer用于添加部分自己想要的配置
 * WebMvcConfigurationSupport全面接管WebMvcConfigtion，全部需要自己配置
 */
@Configuration
public class MVCconfig implements WebMvcConfigurer {

     //登陆拦截器
   /* @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/index","/login","/");
    }*/

   //修改JSON类型
   @Bean
   public FastJsonHttpMessageConverter setFastJson(){
       FastJsonHttpMessageConverter fjc = new FastJsonHttpMessageConverter();
       FastJsonConfig fj = new FastJsonConfig();
       //解决中文乱码问题
       List<MediaType> fastMediaTypes = new ArrayList<MediaType>();
       fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
       fjc.setSupportedMediaTypes(fastMediaTypes);
       fj.setSerializerFeatures(SerializerFeature.DisableCircularReferenceDetect,SerializerFeature.UseSingleQuotes,SerializerFeature.WriteMapNullValue,SerializerFeature.WriteNullStringAsEmpty);
       fjc.setFastJsonConfig(fj);
       return fjc;
   }
   @Bean
    public ErrorProperties getEroPro(){
       return new ErrorProperties();
   }
/*
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(setFastJson());
    }*/
}
