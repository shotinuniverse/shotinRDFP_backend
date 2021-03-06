package backend.repositories

import backend.models.UsersKeys
import backend.models.UsersRoles
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UsersRolesRepository: JpaRepository<UsersRoles, Long> {



}