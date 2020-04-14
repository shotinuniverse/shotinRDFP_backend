package backend.AuthorizationAndUsersRights

import java.util.*
import kotlin.collections.HashMap
import backend.models.AccessRequests
import backend.repositories.AccessRequestsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class AccessRequestsHandle {

    @Autowired
    lateinit var accessRequestsRepository: AccessRequestsRepository

    fun addNewAccessRequest(accessRequests: AccessRequests): String {

        var creatingStatus = ""

        if(accessRequestsRepository.getAccessRequestByUsername(accessRequests.username!!.toCharArray()).isNotEmpty())
            creatingStatus = "ErrorUsername"
        else if(accessRequestsRepository.getAccessRequestByWorkEmail(accessRequests.email_work!!.toCharArray()).isNotEmpty())
            creatingStatus = "ErrorEmail"
        else {
            try {
                accessRequests.accept = false
                accessRequestsRepository.save(accessRequests)
                // Send messages to admins
                creatingStatus = "Success"
            } catch (err: org.springframework.dao.DataIntegrityViolationException) {
                creatingStatus = err.message!!
            }
        }

        return creatingStatus
    }
}