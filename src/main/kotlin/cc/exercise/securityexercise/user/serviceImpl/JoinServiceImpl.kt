package cc.exercise.securityexercise.user.serviceImpl

import cc.exercise.securityexercise.user.dto.JoinDto
import cc.exercise.securityexercise.user.entity.UserEntity
import cc.exercise.securityexercise.user.entity.UserRole
import cc.exercise.securityexercise.user.respository.UserRepository
import cc.exercise.securityexercise.user.service.JoinService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class JoinServiceImpl
@Autowired constructor(
    private val userRepository: UserRepository,
    private val bCryptPasswordEncoder: BCryptPasswordEncoder
):JoinService{
    override fun joinProcess(joinDto: JoinDto) {
        val isUser:Boolean = userRepository.existsByUserName(joinDto.userName)
        if (isUser){
           return
        }

        val data = UserEntity()
        data.userName = joinDto.userName
        data.passWord = bCryptPasswordEncoder.encode(joinDto.passWord)
        data.userRole = UserRole.USER

        userRepository.save(data)
    }
}