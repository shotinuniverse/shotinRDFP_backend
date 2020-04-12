package backend.models

import lombok.AllArgsConstructor
import lombok.Getter
import lombok.Setter
import lombok.ToString
import javax.persistence.*

@Setter
@Getter
@Entity
@Table(name = "remote_desktop_protocols")
@ToString
@AllArgsConstructor
data class RemoteDesktopProtocols(

    @Id
    @Column(name = "_idrref")
    val _idrref: String? = null,

    @Column(name = "_id")
    val _id: Int? = null,

    @Column(name = "name")
    val name: String? = null,

    @Column(name = "ip")
    val ip: String? = null,

    @Column(name = "port")
    val port: String? = null,

    @Column(name = "username")
    val username: String? = null,

    @Column(name = "domain")
    val domain: String? = null,

    @Column(name = "password")
    val password: String? = null,

    @Column(name = "comments")
    val comments: String? = null
)