package spring.starter.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import org.hibernate.validator.constraints.NotEmpty
import java.io.Serializable
import java.util.*
import javax.persistence.*

@Entity
open class User (

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Int? = null,

        @NotEmpty
        var name: String? = null,

        @NotEmpty
        @Column(unique = true, nullable = false)
        var login: String? = null,

        @NotEmpty
        private var password: String? = null,

        // This can't be Set<Role> as Set<Role> means Set<? extends Role> in java and we want Set<Role> which MutableSet provides
        @JsonIgnore
        @ManyToMany(fetch = FetchType.EAGER)
        @JoinTable(name = "user_role", joinColumns = arrayOf(JoinColumn(name = "user_id")), inverseJoinColumns = arrayOf(JoinColumn(name = "role_id")))
        var roles: MutableSet<Role> = HashSet()

) : Serializable {

    constructor(user: User) : this() {
        this.id = user.id
        this.name = user.name
        this.login = user.login
        this.password = user.password
        this.roles = user.roles
    }

    // Needed to get proper override in CustomUserDetailsService
    fun getPassword(): String? = password

    companion object {
        private const val serialVersionUID = 123235L
    }
}