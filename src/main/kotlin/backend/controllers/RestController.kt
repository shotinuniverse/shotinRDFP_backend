package backend.controllers

import backend.common.UsersRights
import backend.models.RemoteDesktopProtocols
import backend.models.Users
import backend.repositories.RemoteDesktopProtocolsRepository
import backend.repositories.UsersRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.RestController
import java.util.*
import kotlin.collections.HashMap


@RestController
@RequestMapping("/api")
class RestController {
    //region declaration_repositories
    @Autowired
    lateinit var remoteDesktopProtocolsRepository: RemoteDesktopProtocolsRepository
    @Autowired
    lateinit var usersRepository: UsersRepository
    @Autowired
    lateinit var usersRights: UsersRights
    //endregion

    //region api_requests
    //region test
    @RequestMapping(value = ["/test"], method = [RequestMethod.GET])
    fun testConnect(): String{
        return "Test has been successfully!"
    }
    //endregion
    @GetMapping(
            path = ["/users-list"],
            produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    @ResponseBody
    fun getUsers(): List<Users>{
        return usersRepository.getUsersList()
    }

    @GetMapping(
            path = ["/users-by-id"],
            produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    @ResponseBody
    fun getUserById(@RequestParam idrref: String): List<Users>{
        return usersRepository.getUserById(UUID.fromString(idrref))
    }

    @GetMapping(
        path = ["/rdp-list"],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    @ResponseBody
    fun getRemoteDesktopProtocolsList(@RequestHeader headers: Map<String?, String?>): HashMap<String,List<RemoteDesktopProtocols>>{
        var remoteDesktopProtocols: HashMap<String, List<RemoteDesktopProtocols>> = hashMapOf()

        when (usersRights.getAccessToDataByHeader(headers)){
            "" -> remoteDesktopProtocols["RemoteDesktopProtocolsData"] = remoteDesktopProtocolsRepository.getRemoteDesktopProtocolsList()
            "errorDateLastEnter" -> remoteDesktopProtocols["errorDateLastEnter"] = mutableListOf()
        }

        return remoteDesktopProtocols
    }

    @GetMapping(
        path = ["/rdp-by-id"],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    @ResponseBody
    fun getRemoteDesktopProtocolById(@RequestParam idrref: String,
                                     @RequestHeader headers: Map<String?, String?>): HashMap<String,List<RemoteDesktopProtocols>>{
        var remoteDesktopProtocols: HashMap<String, List<RemoteDesktopProtocols>> = hashMapOf()

        when (usersRights.getAccessToDataByHeader(headers)){
            "" -> remoteDesktopProtocols["RemoteDesktopProtocolsData"] = remoteDesktopProtocolsRepository.getRemoteDesktopProtocolById(UUID.fromString(idrref))
            "errorDateLastEnter" -> remoteDesktopProtocols["errorDateLastEnter"] = mutableListOf()
        }

        return remoteDesktopProtocols
    }

    //endregion


}