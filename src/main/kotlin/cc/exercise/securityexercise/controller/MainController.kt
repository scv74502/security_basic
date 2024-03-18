package cc.exercise.securityexercise.controller

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping


@Controller
class MainController {
    @GetMapping("/")
    fun mainP():String? {
        val id:String = SecurityContextHolder.getContext().authentication.name

//        val authorities: MutableCollection<out GrantedAuthority>? = SecurityContextHolder.getContext().authentication.authorities
//        val iter: MutableIterator<GrantedAuthority>? = authorities?.iterator()
//        val auth: GrantedAuthority? = iter?.next()
//        val role: String? = auth?.authority

        val authentication = SecurityContextHolder.getContext().authentication

        val authorities = authentication.authorities
        val iter: Iterator<GrantedAuthority> = authorities.iterator()
        val auth = iter.next()
        val role = auth.authority
        return "main"
    }
}