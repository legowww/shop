package com.ecm.coreapi.global;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.filter.ShallowEtagHeaderFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.WebContentInterceptor;

import java.time.Duration;

@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(final InterceptorRegistry registry) {
        WebContentInterceptor interceptor = new WebContentInterceptor();

        CacheControl cacheControl = CacheControl.maxAge(Duration.ofDays(365)).cachePrivate();
        interceptor.addCacheMapping(cacheControl, "/");
        registry.addInterceptor(interceptor);
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean registration = new FilterRegistrationBean();
        ShallowEtagHeaderFilter shallowEtagHeaderFilter = new ShallowEtagHeaderFilter();
        registration.setFilter(shallowEtagHeaderFilter);
        registration.addUrlPatterns("/");

        return registration;
    }
}
