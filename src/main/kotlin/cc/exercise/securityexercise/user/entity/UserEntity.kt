package cc.exercise.securityexercise.user.entity

import jakarta.persistence.*

@Entity
@Table(name = "user")
class UserEntity {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var userId: Long ?= null

    @Column(name = "user_name", unique = true)
    var userName: String ?= null

    @Column(name = "password")
    var passWord: String ?= null

    @Column(name = "user_role")
    var userRole: UserRole ?= UserRole.USER
}

enum class UserRole(val role:String){
    USER("USER"),
    ADMIN("ADMIN")
}