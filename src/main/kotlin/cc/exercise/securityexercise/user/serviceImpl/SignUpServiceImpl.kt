package cc.exercise.securityexercise.user.serviceImpl

import cc.exercise.securityexercise.user.dto.SignUpDto
import cc.exercise.securityexercise.user.entity.User
import cc.exercise.securityexercise.user.respository.UserRepository
import cc.exercise.securityexercise.user.service.SignUpService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class SignUpServiceImpl
@Autowired constructor(
    private val userRepository: UserRepository,
    private val bCryptPasswordEncoder: BCryptPasswordEncoder
):SignUpService{
    override fun signUpProcess(signUpDto: SignUpDto) {
        val data = User()
        data.userName = signUpDto.userName
        data.passWord = bCryptPasswordEncoder.encode(signUpDto.passWord)

        userRepository.save(data)
    }
}