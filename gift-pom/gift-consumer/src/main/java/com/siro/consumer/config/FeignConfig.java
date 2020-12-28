package com.siro.consumer.config;

import com.siro.consumer.utils.FeignHystrixConcurrencyStrategy;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @author mshcc
 * @date 2020/12/27
 */
@Configuration
public class FeignConfig implements RequestInterceptor {
    private final Logger logger = LoggerFactory.getLogger(FeignConfig.class);
    @Override
    public void apply(RequestTemplate template) {

        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes == null) {
            return;
        }
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
        Enumeration<String> headerNames = request.getHeaderNames();
        if (headerNames != null) {
            while (headerNames.hasMoreElements()) {
                String name = headerNames.nextElement();
                Enumeration<String> values = request.getHeaders(name);
                while (values.hasMoreElements()) {
                    String value = values.nextElement();
                    logger.warn("name:"+name+";value:"+value);
                    template.header(name, value);
                }
            }
        }
    }
    @Bean
    public FeignHystrixConcurrencyStrategy feignHystrixConcurrencyStrategy(){
        return new FeignHystrixConcurrencyStrategy();
    }
}