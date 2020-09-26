package com.example.test2.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.*;

//使用WebMvcConfigurerAdapter可以来扩展SpringMVC的公分呢个
//@EnableWebMvc   不要接管SpringMVC
@Configuration
public class MyMvcConfig  implements WebMvcConfigurer {

    //所有的WebMvcConfigurerAdapter组件都会一起起作用
    @Bean  //将组件注册在容器
    public WebMvcConfigurerAdapter webMvcAutoConfigurationAdapter()
    {
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            public void addViewControllers(ViewControllerRegistry registry)
            {
                registry.addViewController("/").setViewName("index");

                registry.addViewController("/index.html").setViewName("index");

            }

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //super.addInterceptors(registry);
              /*  registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                        .excludePathPatterns("/index.html","/","/login");*/
            }
        };
        return adapter;
    }

}
