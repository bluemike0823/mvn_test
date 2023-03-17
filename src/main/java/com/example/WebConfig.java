// package com.example;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.ComponentScan;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.context.annotation.PropertySource;
// import org.springframework.web.servlet.ViewResolver;
// import org.springframework.web.servlet.config.annotation.EnableWebMvc;
// import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
// import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
// import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
// import org.springframework.web.servlet.view.InternalResourceViewResolver;

// @Configuration
// @EnableWebMvc
// // @PropertySource("classpath:path.properties")
// // @ComponentScan("com.example.Controller")
// public class WebConfig implements WebMvcConfigurer {


//     @Override
//     public void addViewControllers(ViewControllerRegistry registry) {
//         System.out.println("run viewcontroller");
//         registry.addViewController("/index").setViewName("index");
//         // registry.addViewController("/").setViewName("home");
//     }

//     @Bean
//     public ViewResolver viewResolver() {
//     InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//     System.out.println("run viewResolver");
//     viewResolver.setPrefix("classpath:/templates/");
//     viewResolver.setSuffix(".html");

//     return viewResolver;
// }

    
// }
