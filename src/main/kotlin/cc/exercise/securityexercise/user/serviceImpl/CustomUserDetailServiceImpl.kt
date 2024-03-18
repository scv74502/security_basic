package cc.exercise.securityexercise.user.serviceImpl

import cc.exercise.securityexercise.user.dto.CustomUserDetails
import cc.exercise.securityexercise.user.entity.UserEntity
import cc.exercise.securityexercise.user.respository.UserRepository
import cc.exercise.securityexercise.user.service.CustomUserDetailsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service

@Service
class CustomUserDetailServiceImpl
@Autowired constructor(
    private val userRepository: UserRepository
):CustomUserDetailsService {
    override fun loadUserByUsername(userName: String): UserDetails? {
        val userData:UserEntity? = userRepository.findByUserName(userName)
        if (userData != null){
            return CustomUserDetails(userData)
        }
        return null
    }
}