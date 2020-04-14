package backend.controllers

import backend.AuthorizationAndUsersRights.Authorization
import backend.AuthorizationAndUsersRights.UsersRights
import backend.repositories.UsersRepository
import org.springframework.beans.factory.annotation.Autowired
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

    // Return api_key for user
    @RequestMapping(
        path = ["/signin"], method = [RequestMethod.GET]
    )@ResponseBody
    fun takeAuthorization(@RequestParam username: String,
                          @RequestParam password: String): String{
        return authorization.takeAuthorization(username, password)
    }
}