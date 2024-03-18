package cc.exercise.securityexercise.user.controller

import cc.exercise.securityexercise.user.dto.JoinDto
import cc.exercise.securityexercise.user.service.JoinService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping

@Controller
class JoinController
@Autowired constructor(
    private val joinService: JoinService
) {
    @GetMapping("/join")
    fun signUpP():String {
        return "join"
    }

    @PostMapping("/joinProc")
    fun signUpProcess(joinDto: JoinDto):String {
        println(joinDto.userName)
        joinService.joinProcess(joinDto)
        return "redirect:/login"
    }
}