package backend.repositories

import backend.models.Users
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UsersRepository: JpaRepository<Users, Long> {
    @Async
    @Query(
        value = "/* USERS LIST */\n" +
                "select\n" +
                "\tusers._idrref as _idrref,\n" +
                "\tusers._id as _id,\n" +
                "\tusers.username as username,\n" +
                "\tencode(users.password, 'escape') as password,\n" +
                "\tusers.email_work as email_work,\n" +
                //"\tusers.date_last_enter as date_last_enter,\n" +
                "\tusers.is_admin as is_admin\n" +
                "from\n" +
                "\tusers as users",
        nativeQuery = true
    )
    fun getUsersList(): List<Users>

    @Async
    @Query(
        value = "/* USER BY IDRREF */\n" +
                "select\n" +
                "\tusers._idrref as _idrref,\n" +
                "\tusers._id as _id,\n" +
                "\tusers.username as username,\n" +
                "\tencode(users.password, 'escape') as password,\n" +
                "\tusers.email_work as email_work,\n" +
                //"\tusers.date_last_enter as date_last_enter,\n" +
                "\tusers.is_admin as is_admin\n" +
                "from\n" +
                "\tusers as users\n" +
                "where\n" +
                "\tusers._idrref = :idrref",
        nativeQuery = true
    )
    fun getUserById(@Param("idrref") idrref: UUID): List<Users>
}