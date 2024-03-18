package cc.exercise.securityexercise.user.service

import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService

interface CustomUserDetailsService:UserDetailsService {
    override fun loadUserByUsername(userName: String): UserDetails?
}