package cc.exercise.securityexercise.user.service

import cc.exercise.securityexercise.user.dto.SignUpDto

interface SignUpService {
    fun signUpProcess(signUpDto: SignUpDto)
}