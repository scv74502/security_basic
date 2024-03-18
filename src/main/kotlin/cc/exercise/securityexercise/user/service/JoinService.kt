package cc.exercise.securityexercise.user.service

import cc.exercise.securityexercise.user.dto.JoinDto

interface JoinService {
    fun joinProcess(joinDto: JoinDto)
}