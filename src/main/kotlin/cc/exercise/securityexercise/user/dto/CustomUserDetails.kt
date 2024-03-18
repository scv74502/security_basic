package cc.exercise.securityexercise.user.dto

import cc.exercise.securityexercise.user.entity.UserEntity
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class CustomUserDetails(user: UserEntity) : UserDetails {
    private val userEntity: UserEntity = user


    override fun getAuthorities(): Collection<GrantedAuthority> {
        val collection: MutableCollection<GrantedAuthority> = ArrayList()
        collection.add(GrantedAuthority { userEntity.userRole.toString() })
        return collection
    }

    override fun getPassword(): String? {
        return userEntity.passWord
    }

    override fun getUsername(): String? {
        return userEntity.userName
    }


    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }
}