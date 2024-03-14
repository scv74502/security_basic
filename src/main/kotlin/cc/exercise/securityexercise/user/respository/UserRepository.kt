package cc.exercise.securityexercise.user.respository

import cc.exercise.securityexercise.user.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: JpaRepository<User, Long >{
}