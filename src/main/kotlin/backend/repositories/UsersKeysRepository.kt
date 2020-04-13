package backend.repositories

import backend.models.UsersKeys
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UsersKeysRepository: JpaRepository<UsersKeys, Long> {

    @Query("select usrk._idrref, usrk._id, usrk.user_uuid, usrk.api_key, usrk.date_last_login\n" +
            //"TO_CHAR(usrk.date_last_login :: DATE, 'dd.mm.yyyy hh24:mi:ss') as date_last_login\n" +
            "from users_keys as usrk where usrk.user_uuid = :idrref", nativeQuery = true)
    fun getUserKeyByUserUUID(@Param("idrref") idrref: UUID): List<UsersKeys>

    @Query("select usrk._idrref, usrk._id, usrk.user_uuid, usrk.api_key, usrk.date_last_login\n" +
           // "TO_CHAR(usrk.date_last_login :: DATE, 'dd.mm.yyyy hh24:mi:ss') as date_last_login\n" +
            "from users_keys as usrk where usrk.user_uuid = :idrref and usrk.api_key = :api_key",
        nativeQuery = true)
    fun getUserKeyByUserUUIDAndApiKey(@Param("idrref") idrref: UUID,
                                      @Param("api_key") api_key: String): List<UsersKeys>

}