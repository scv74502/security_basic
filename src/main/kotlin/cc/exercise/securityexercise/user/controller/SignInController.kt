package cc.exercise.securityexercise.user.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class SignInController{
    @GetMapping("/signIn")
    fun signInP(): String {
        return "signIn"
    }
}
