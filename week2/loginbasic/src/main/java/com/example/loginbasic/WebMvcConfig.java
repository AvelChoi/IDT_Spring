package com.example.loginbasic;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    // Spring에서 제공, 인터럽트, 프리 핸들러 등등
    // 해당 컨트롤러로 맵핑을 하기 전에 해야하는 몇가지에 대해서 등록할 때 사용되는 것이 바로 이 WebMvcConfigurer

//    @Override
    public void addInterceptor(InterceptorRegistry registry) {
        // 인터셉터를 적용할 경로 지정
        registry.addInterceptor(new LoginIntercept())
                .addPathPatterns("/service*")
                .addPathPatterns("/admin")
                .excludePathPatterns("/vendor/**", "/css/*", "/img/*");
    }

}
