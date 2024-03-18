package cc.exercise.securityexercise.user.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class LoginController{
    @GetMapping("/login")
    fun loginP(): String {
        return "login"
    }
}
