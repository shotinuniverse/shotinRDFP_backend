package backend.repositories

import backend.models.AccessRequests
import backend.models.Config
import backend.models.TypesRoles
import backend.models.UsersKeys
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface TypesRolesRepository: JpaRepository<TypesRoles, Long> {



}