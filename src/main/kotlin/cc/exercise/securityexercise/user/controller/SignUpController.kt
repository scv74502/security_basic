package cc.exercise.securityexercise.user.controller

import cc.exercise.securityexercise.user.dto.SignUpDto
import cc.exercise.securityexercise.user.service.SignUpService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping

@Controller
class SignUpController
@Autowired constructor(
    private val signUpService: SignUpService
) {
    @GetMapping("/signUp")
    fun joinP():String {
        return "signUp"
    }

    @PostMapping("/signUpProc")
    fun signUpProcess(signUpDto: SignUpDto):String {
        println(signUpDto.userName)
        signUpService.signUpProcess(signUpDto)
        return "redirect:/signIn"
    }
}