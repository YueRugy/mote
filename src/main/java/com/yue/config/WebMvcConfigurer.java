package com.yue.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by admin on 2017/1/5
 */
@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {

    /* private MappingJackson2HttpMessageConverter jacksonMessageConverter() {
         MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();

         ObjectMapper mapper = new ObjectMapper();
         //Registering Hibernate4Module to support lazy objects
         mapper.registerModule(new Hibernate4Module());

         messageConverter.setObjectMapper(mapper);
         return messageConverter;

     }
 */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new HandlerInterceptorAdapter() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                //System.out.println("interceptor..................");
                return super.preHandle(request, response, handler);
            }
        }).addPathPatterns("/**");

    }




   /* @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(jacksonMessageConverter());
        super.configureMessageConverters(converters);
    }*/


    @Bean
    @Order(1)
    public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
        return new HiddenHttpMethodFilter();
    }
}
