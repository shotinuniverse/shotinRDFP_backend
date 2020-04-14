package backend.models

import lombok.AllArgsConstructor
import lombok.Getter
import lombok.Setter
import lombok.ToString
import java.util.*
import javax.persistence.*

@Setter
@Getter
@Entity
@Table(name = "types_roles")
@ToString
@AllArgsConstructor
data class TypesRoles (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "_idrref")
    val _idrref: UUID? = null,

    @Column(name = "_id")
    val _id: Long? = null,

    @Column(name = "role_type")
    val role_type: String? = null,

    @Column(name = "role_type_ru")
    val role_type_ru: String? = null
)