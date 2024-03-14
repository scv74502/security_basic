package cc.exercise.securityexercise.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class MainController {
    @GetMapping("/")
    fun mainP():String {
        return "main";
    }
}