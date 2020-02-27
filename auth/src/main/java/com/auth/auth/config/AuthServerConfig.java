package com.auth.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

public class AuthServerConfig extends WebSecurityConfigurerAdapter implements AuthorizationServerConfigurer {
    @Override
    public void configure(AuthorizationServerSecurityConfigurer authorizationServerSecurityConfigurer) throws Exception {
        authorizationServerSecurityConfigurer.checkTokenAccess("permitAll");
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clientDetailsServiceConfigurer) throws Exception {

    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer authorizationServerEndpointsConfigurer) throws Exception {


    }
    @Bean
    public AuthenticationManager authenticationManager() throws Exception{
        return super.authenticationManagerBean();
    }

    @Autowired
    AuthenticationManager authenticationManager;
    PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
}
