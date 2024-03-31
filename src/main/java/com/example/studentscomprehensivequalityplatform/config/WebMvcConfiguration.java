package com.example.studentscomprehensivequalityplatform.config;

import com.example.studentscomprehensivequalityplatform.interceptor.JwtTokenStuOrganizationInterceptor;
import com.example.studentscomprehensivequalityplatform.interceptor.JwtTokenStudentInterceptor;
import com.example.studentscomprehensivequalityplatform.interceptor.JwtTokenTeacherInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@Slf4j
public class WebMvcConfiguration extends WebMvcConfigurationSupport {

    @Autowired
    private JwtTokenStudentInterceptor jwtTokenStudentInterceptor;
    @Autowired
    private JwtTokenTeacherInterceptor jwtTokenTeacherInterceptor;
    @Autowired
    private JwtTokenStuOrganizationInterceptor jwtTokenStuOrganizationInterceptor;

    /**
     * 注册自定义拦截器
     *
     * @param registry
     */
    protected void addInterceptors(InterceptorRegistry registry) {
        log.info("开始注册自定义拦截器...");
        registry.addInterceptor(jwtTokenStudentInterceptor)
                .addPathPatterns("/students/**")
                .excludePathPatterns("/students/common/login");

        registry.addInterceptor(jwtTokenStuOrganizationInterceptor)
                .addPathPatterns("/stuOrganization/**")
                .excludePathPatterns("/stuOrganization/common/login");

        registry.addInterceptor(jwtTokenTeacherInterceptor)
                .addPathPatterns("/teacher/**")
                .excludePathPatterns("/teacher/common/login");
    }

}
