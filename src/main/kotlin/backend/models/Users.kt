package backend.models

import lombok.AllArgsConstructor
import lombok.Getter
import lombok.Setter
import lombok.ToString
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Setter
@Getter
@Entity
@Table(name = "users")
@ToString
@AllArgsConstructor
data class Users (
    @Id
    @Column(name = "_idrref")
    val _idrref: String? = null,

    @Column(name = "_id")
    val _id: Int? = null,

    @Column(name = "username")
    val username: String? = null,

    @Column(name = "password")
    val password: String? = null,

    @Column(name = "email_work")
    val email_work: String? = null,

    @Column(name = "date_last_enter")
    val date_last_enter: String? = null,

    @Column(name = "is_admin")
    val is_admin: String? = null
)