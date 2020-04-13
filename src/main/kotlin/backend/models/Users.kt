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
@Table(name = "users")
@ToString
@AllArgsConstructor
data class Users (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "_idrref")
    val _idrref: UUID? = null,

    @Column(name = "_id")
    val _id: Long? = null,

    @Column(name = "username")
    val username: String? = null,

    @Column(name = "password")
    val password: String? = null,

    @Column(name = "email_work")
    val email_work: String? = null,

    @Column(name = "is_admin")
    val is_admin: String? = null
)