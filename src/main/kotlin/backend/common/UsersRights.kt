package backend.common

import backend.repositories.ConfigRepository
import backend.repositories.UsersKeysRepository
import backend.repositories.UsersRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit
import java.util.*

@Component
class UsersRights {
    @Autowired
    lateinit var usersKeysRepository: UsersKeysRepository
    @Autowired
    lateinit var configRepository: ConfigRepository

    fun getRandomKey(): String{
        val charPool : List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')

        val randomString = (1..40)
                .map { i -> kotlin.random.Random.nextInt(0, charPool.size) }
                .map(charPool::get)
                .joinToString("")

        return randomString
    }

    fun getAccessToDataByHeader(headers: Map<String?, String?>): String{
        //var apikey = getRandomKey()

        var idrrefUser: String = ""
        var apiKey: String = ""

        for (item in headers) {
            when (item.key) {
                "idrref_user" -> idrrefUser = item.value!!
                "api_key" -> apiKey = item.value!!
            }
        }

        val userKeyPair = usersKeysRepository.getUserKeyByUserUUIDAndApiKey(UUID.fromString(idrrefUser), apiKey)
        val workingWithDate = WorkingWithDate()

        var numberOfDayReloadDateLogin = configRepository.findById(1).get().number_of_day_reload_date_login!!

        var answerAccess: String = "errorNoApiKey";

        if(userKeyPair.size == 1){

            var dateFromDB: LocalDateTime =
                workingWithDate.getLocalDateFromSQLDate(userKeyPair.get(0).date_last_login!!)
            var dateNow: LocalDateTime = LocalDateTime.now()

            var resultDays: Long = ChronoUnit.DAYS.between(dateFromDB, dateNow)

            if (resultDays >= numberOfDayReloadDateLogin) answerAccess = "errorDateLastLogin"
            else answerAccess = ""

        }

        return answerAccess
    }


}