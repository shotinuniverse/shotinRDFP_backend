package backend.repositories

import backend.models.AccessRequests
import backend.models.Config
import backend.models.UsersKeys
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Repository
import org.springframework.web.bind.annotation.RequestParam
import java.util.*

@Repository
interface AccessRequestsRepository: JpaRepository<AccessRequests, Long> {
    @Async
    @Query(
        value = "select * from access_request where username = :username",
        nativeQuery = true
    )
    fun getAccessRequestByUsername(@Param("username") username: CharArray): List<AccessRequests>

    @Async
    @Query(
        value = "select * from access_request where email_work = :email_work",
        nativeQuery = true
    )
    fun getAccessRequestByWorkEmail(@Param("email_work") email_work: CharArray): List<AccessRequests>

    @Async
    @Query(
        value = "select * from access_request where accept = false",
        nativeQuery = true
    )
    fun getAccessRequestNotAccepted(): List<AccessRequests>

    @Async
    @Query(
        value = "select * from access_request",
        nativeQuery = true
    )
    fun getAccessRequestList(): List<AccessRequests>
}