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
                    .requestMatchers("/", "/login","/loginProc","/join", "/joinProc").permitAll()
                    .requestMatchers("/admin").hasRole("ADMIN")
                    .requestMatchers("/my/**").hasAnyRole("ADMIN", "USER")
                    .anyRequest().authenticated()
            }

        http
            .formLogin { auth -> auth.loginPage("/login")
                .loginProcessingUrl("/loginProc")
                    .permitAll()
            }

        // 로그아웃 설정
        http
            .logout { auth -> auth.logoutUrl("/logout")
                .logoutSuccessUrl("/")}

        http
//            .csrf{auth -> auth.disable()}   // csrf disable configuration

        http
            .sessionManagement { auth -> auth   // 세션 설정 관리하는 메소드
                .sessionFixation().changeSessionId()    // 로그인 시 동일한 세션에 대한 id 변경
                .maximumSessions(1) // 하나의 아이디에 대한 다중 로그인 허용 개수
                .maxSessionsPreventsLogin(true)}

        return http.build()
    }

    @Bean
    fun bCryptPassEncoder(): BCryptPasswordEncoder = BCryptPasswordEncoder()

}