package com.bysj.qiu.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class Security extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers().permitAll()

//               想要进入admin下的所有路径需要有名为ADMIN的权限
                .antMatchers("/admin/*").hasRole("ADMIN")
                .antMatchers("/adminshopitem/*").hasRole("ADMIN")
                .antMatchers("/adminshoweacharts/*").hasRole("ADMIN")
                .antMatchers("/adminsystemmanager/*").hasRole("ADMIN")
                .antMatchers("/other/*").hasRole("USER")
                .antMatchers("/otherexpress/*").hasRole("USER")
                .antMatchers("/othercomment/*").hasRole("USER")
                .antMatchers("/othershopcar/*").hasRole("USER")
                .antMatchers("/ERROR").hasRole("ERROR")
        ;
        //成功时跳到/continue
        http.formLogin().usernameParameter("user").passwordParameter("password").loginPage("/").loginProcessingUrl("/start/startlogin").successForwardUrl("/continue");
        http.logout().logoutUrl("/end/logout").logoutSuccessUrl("/").invalidateHttpSession(true);
    }

}
