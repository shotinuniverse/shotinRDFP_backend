package backend.models

import backend.repositories.UsersRepository
import lombok.AllArgsConstructor
import lombok.Getter
import lombok.Setter
import lombok.ToString
import org.apache.catalina.User
import java.util.*
import javax.persistence.*

@Setter
@Getter
@Entity
@Table(name = "users_keys")
@ToString
@AllArgsConstructor
data class UsersKeys(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "_idrref")
        val _idrref: UUID? = null,

        @Column(name = "_id")
        val _id: Long? = null,

        @Column(name = "user_uuid")
        val user_uuid: UUID? = null,

//        @OneToOne
//        @JoinColumn(name = "user_uuid", referencedColumnName = "_idrref")
//        val user: Users,

        @Column(name = "api_key")
        val api_key: String? = null,

        @Column(name = "date_last_login")
        val date_last_login: String? = null
)