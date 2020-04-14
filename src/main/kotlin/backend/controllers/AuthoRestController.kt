package backend.controllers

import backend.AuthorizationAndUsersRights.AccessRequestsHandle
import backend.AuthorizationAndUsersRights.Authorization
import backend.AuthorizationAndUsersRights.UsersRights
import backend.models.AccessRequests
import backend.repositories.UsersRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/authorization")
class AuthoRestController {
    @Autowired
    lateinit var usersRepository: UsersRepository
    @Autowired
    lateinit var usersRights: UsersRights
    @Autowired
    lateinit var authorization: Authorization
    @Autowired
    lateinit var accessRequestsHandle: AccessRequestsHandle

    /*
    Возвращает статус создания заявки доступа:
    * 1) Success - заявка успешно создана. Заявка доступа отправлена администраторам на одобрение.,
    * 2) ErrorEmail - такая почта уже существует,
    * 3) ErrorUsername - такое имя пользователя уже существует,
    * 4) ErrorOther - возникли непредвиденные обстоятельства. Обратитесь к администратору.
    */
    @RequestMapping(path = ["/create-access-request"],
        method = [RequestMethod.POST], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun createAccessRequest(@RequestBody accessRequests: AccessRequests): String?{

        return accessRequestsHandle.addNewAccessRequest(accessRequests)
    }

    // Return api_key for user
    @RequestMapping(
        path = ["/signin"], method = [RequestMethod.GET]
    )@ResponseBody
    fun takeAuthorization(@RequestParam username: String,
                          @RequestParam password: String): String{
        return authorization.takeAuthorization(username, password)
    }
}