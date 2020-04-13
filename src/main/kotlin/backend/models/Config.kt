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
@Table(name = "config")
@ToString
@AllArgsConstructor
data class Config(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "_id")
        val _id: Long? = null,

        @Column(name = "number_of_day_reload_date_login")
        val number_of_day_reload_date_login: Int? = null
    )
