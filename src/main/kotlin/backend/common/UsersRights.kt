package backend.common

import backend.repositories.UsersRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.*

@Component
class UsersRights {
    @Autowired
    lateinit var usersRepository: UsersRepository

    fun getAccessToDataByHeader(headers: Map<String?, String?>): String{
        var idrref_user: String = ""
        //var password: String = ""
        var date_request: String = ""

        for (item in headers) {
            when (item.key) {
                "idrref_user" -> idrref_user = item.value!!
                //"password" -> password = item.value!!
                "date_request" -> date_request = item.value!!
            }
        }

        val users = usersRepository.getUserById(UUID.fromString(idrref_user))

        if(users.size == 1) {

        }

        return ""
    }
}