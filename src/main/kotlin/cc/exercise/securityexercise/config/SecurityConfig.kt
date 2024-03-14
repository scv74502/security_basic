package cc.exercise.securityexercise.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.SecurityFilterChain


@Configuration
@EnableWebSecurity
class SecurityConfig {
    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
//        http
//            .authorizeHttpRequests { auth ->
//                auth
//                    .requestMatchers("/", "/login").permitAll()
//                    .requestMatchers("/admin").hasRole("ADMIN")
//                    .requestMatchers("/my/**").hasAnyRole("ADMIN", "USER")
//                    .anyRequest().authenticated()
//            }
//
//        return http.build()
        http
            .authorizeHttpRequests { auth ->
                auth
                    .requestMatchers("/", "/signUp","/signUpProc","/signIn", "/signInProc").permitAll()
                    .requestMatchers("/admin").hasRole("ADMIN")
                    .requestMatchers("/my/**").hasAnyRole("ADMIN", "USER")
                    .anyRequest().authenticated()
            }

        http
            .formLogin { auth ->
                auth.loginPage("/signinProc")
                    .permitAll()
            }

        http
            .csrf{auth ->
                auth.disable()
            }

        return http.build()
    }

    @Bean
    fun bCryptPassEncoder(): BCryptPasswordEncoder = BCryptPasswordEncoder()

}