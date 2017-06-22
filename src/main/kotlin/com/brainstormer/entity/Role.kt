package com.brainstormer.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import org.hibernate.validator.constraints.NotEmpty
import org.springframework.security.core.GrantedAuthority
import java.io.Serializable
import javax.persistence.*

@Entity
class Role (

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Int? = null,

        @NotEmpty
        var name: String? = null,

        // This can't be Set<User> as Set<User> means Set<? extends User> in java and we want Set<User> which MutableSet provides
        @JsonIgnore
        @ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
        var users: MutableSet<User> = HashSet()

): Serializable, GrantedAuthority {
    override fun getAuthority(): String? {
        return name
    }

    companion object {
        private const val serialVersionUID = 1947934L
    }
}