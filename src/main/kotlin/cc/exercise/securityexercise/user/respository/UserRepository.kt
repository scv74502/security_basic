package cc.exercise.securityexercise.user.respository

import cc.exercise.securityexercise.user.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: JpaRepository<UserEntity, Long >{
    fun existsByUserName(userName: String):Boolean

    fun findByUserName(userName: String):UserEntity?
}