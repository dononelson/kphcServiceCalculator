package com.kaiser;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@ImportResource(value = "classpath:META-INF/base-app-context.xml")
@ComponentScan(basePackages = { "com.kaiser", "com.kaiser.controller", "com.kaiser.config.security" })
@EnableAutoConfiguration
public class Application {

    /**
     * @param args
     */
    public static void main(final String[] args) {
        final SpringApplicationBuilder builder = new SpringApplicationBuilder(Application.class);
        builder.headless(true);
        builder.showBanner(false);
        builder.run(args);
    }

}
