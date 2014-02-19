package com.kaiser.config.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Configuration
public class HandlerConfig {
    // @Autowired
    // private ApplicationContext applicationContext;

    @Bean
    public HandlerInterceptor getLoggingInterceptor(final RequestMappingHandlerMapping handlerMapping) {
        final HandlerInterceptor interceptor = new HandlerInterceptor() {

            @Override
            public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler) throws Exception {
                System.out.println("preHandle");
                return true;
            }

            @Override
            public void postHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler, final ModelAndView modelAndView)
                    throws Exception {
                System.out.println("postHandle");
            }

            @Override
            public void afterCompletion(final HttpServletRequest request, final HttpServletResponse response, final Object handler, final Exception ex)
                    throws Exception {
                System.out.println("afterCompletion");
            }
        };
        // final Object[] interceptors = { interceptor };
        // handlerMapping.setInterceptors(interceptors);
        // handlerMapping.afterPropertiesSet();
        return interceptor;
    }
}
