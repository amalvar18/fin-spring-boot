/**
 * 
 */
package com.finomyr.finomyrapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.finomyr.finomyrapp.utils.FinomyrUIConstants;

/**
 * @author amalvar
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    /*
     * @Autowired private DataSource dataSource;
     * 
     * @Value("${spring.queries.users-query}") private String usersQuery;
     * 
     * @Override protected void configure(AuthenticationManagerBuilder auth)
     * throws Exception {
     * auth.jdbcAuthentication().usersByUsernameQuery(usersQuery)
     * .authoritiesByUsernameQuery(rolesQuery)
     * .dataSource(dataSource).passwordEncoder(bCryptPasswordEncoder); }
     */
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/register", "/registration").permitAll()
                .antMatchers("/admin/**").hasAuthority("ADMIN").anyRequest()
                .authenticated().and().csrf().disable().formLogin()
                .loginPage("/login").failureUrl("/login?error=true")
                .defaultSuccessUrl("/layout")
                .usernameParameter("email")
                .passwordParameter("password")
                .and().logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl(FinomyrUIConstants.LOGOUT_SUCCESS_URL).and().exceptionHandling()
                .accessDeniedPage("/access-denied");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**",
                        "/images/**", "/fonts/**");
    }

    /*
     * @Bean public BCryptPasswordEncoder passwordEncoder() {
     * BCryptPasswordEncoder bCryptPasswordEncoder = new
     * BCryptPasswordEncoder(); return bCryptPasswordEncoder; }
     */

}
