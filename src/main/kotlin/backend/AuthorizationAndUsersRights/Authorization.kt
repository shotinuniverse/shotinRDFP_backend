package backend.AuthorizationAndUsersRights

import backend.repositories.UsersRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class Authorization {

    @Autowired
    lateinit var usersRepository: UsersRepository

    fun getRandomKey(): String{
        val charPool : List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')

        val randomString = (1..40)
            .map { i -> kotlin.random.Random.nextInt(0, charPool.size) }
            .map(charPool::get)
            .joinToString("")

        return randomString
    }

    fun takeAuthorization(username: String, password: String): String{
        var userFromNameAndPassPair = usersRepository.getUserByUsernameAndPassword(username, password)

        return ""
    }
}