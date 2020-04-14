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
@Table(name = "access_request")
@ToString
@AllArgsConstructor
data class AccessRequests (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "_id")
    val _id: Long? = null,

    @Column(name = "username")
    val username: String? = null,

    @Column(name = "email_work")
    val email_work: String? = null,

    @Column(name = "accept")
    var accept: Boolean? = null
)