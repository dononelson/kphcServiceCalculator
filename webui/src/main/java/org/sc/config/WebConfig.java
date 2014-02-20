package org.sc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
public class WebConfig {

	@Bean
	public WebMvcConfigurerAdapter getWebMvcConfigurerAdapter() {

		final WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {

			@Override
			public void addResourceHandlers(
					final ResourceHandlerRegistry registry) {

				registry.addResourceHandler("/public-resources/**")
						.addResourceLocations("/WEB-INF/public-resources/");

				registry.addResourceHandler("/js/**").addResourceLocations(
						"/WEB-INF/public-resources/js/");

			}

		};

		return adapter;

	}

	@Bean
	public InternalResourceViewResolver getInternalResourceViewResolver() {

		final InternalResourceViewResolver resolver = new InternalResourceViewResolver();

		resolver.setPrefix("/WEB-INF/views/");

		resolver.setSuffix(".jsp");

		return resolver;

	}

}