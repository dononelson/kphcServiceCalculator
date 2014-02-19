package com.kaiser.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity(debug = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(final AuthenticationManagerBuilder authManagerBuilder) throws Exception {
        // final InMemoryUserDetailsManagerConfigurer<AuthenticationManagerBuilder> inMemoryAuthentication = authManagerBuilder.inMemoryAuthentication();
        // final String password = "supersecureemcpassword";
        // final String roles = "USER";
        // inMemoryAuthentication.withUser("btran").password(password).roles(roles);
        // inMemoryAuthentication.withUser("dnelson").password(password).roles(roles);
        // inMemoryAuthentication.withUser("gfoster").password(password).roles(roles);

        // This is an example of using ldap to secure the web service
        // final String userDnPatterns = "uid={0},ou=people";
        // final String groupSearchBase = "ou=groups";
        // final LdapAuthenticationProviderConfigurer<AuthenticationManagerBuilder> ldapAuthentication = authManagerBuilder.ldapAuthentication();
        // ldapAuthentication.userDnPatterns(userDnPatterns);
        // ldapAuthentication.groupSearchBase(groupSearchBase);
        // final LdapAuthenticationProviderConfigurer<AuthenticationManagerBuilder>.ContextSourceBuilder contextSource = ldapAuthentication.contextSource();
        // final String ldif = "classpath:test-server.ldif";
        // contextSource.ldif(ldif);
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        // http.authorizeRequests().antMatchers("/signup", "/about").permitAll() // #4
        // .antMatchers("/admin/**").hasRole("ADMIN") // #6
        // .anyRequest().authenticated() // 7
        // .and().formLogin().permitAll(); // #5
    }

    @Override
    public void configure(final WebSecurity web) throws Exception {
        // final IgnoredRequestConfigurer ignoring = web.ignoring();
        // ignoring.antMatchers("/resources/**");
    }
}
