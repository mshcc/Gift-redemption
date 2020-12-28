package com.siro.demo.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.servlet.Servlet;

/**
 * @author mshcc
 * @date 2020/12/23
 * TODO 注入属性和配 置连接池相关的配置，如黑白名单、监控管理后台登录账户密码
 */
@Configuration
public class DruidConfig {
    @ConditionalOnMissingBean
    @Bean
    public ServletRegistrationBean<Servlet> druidServlet() {
        ServletRegistrationBean<Servlet> registrationBean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        //白名单
        registrationBean.addInitParameter("allow", "0.0.0.0");
        //黑名单，黑白名单都有时，黑名单优先
        registrationBean.addInitParameter("deny", "192.168.1.119");
        //设置账号密码
        registrationBean.addInitParameter("loginUsername", "admin");
        registrationBean.addInitParameter("loginPassword", "admin");
        //是否可以重置数据
        registrationBean.addInitParameter("resetEnable", "admin");
        return registrationBean;
    }

    @Bean
    @ConditionalOnMissingBean
    public FilterRegistrationBean<Filter> filterFilterRegistrationBean() {
        // TODO 监控拦截器
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }
}
