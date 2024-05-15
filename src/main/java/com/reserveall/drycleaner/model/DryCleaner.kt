package com.reserveall.drycleaner.model

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import java.util.ArrayList

@Entity
@Table(name = "drycleaners")
data class DryCleaner @JvmOverloads constructor(
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    val id: String? = "",

    @Column(name = "created_date")
    @CreationTimestamp
    val createdDate: LocalDateTime? = null,

    @Column(name = "updated_date")
    @UpdateTimestamp
    val updatedDate: LocalDateTime? = null,

    @Column(name = "name")
    val name: String?,

    @Column(name = "location")
    val location: String?,

    @Column(name = "description")
    val description: String?,

    @OneToMany(cascade = [CascadeType.ALL], mappedBy = "dryCleaner")
    val services: List<Service>? ,

    @OneToMany(cascade = [CascadeType.ALL], mappedBy = "dryCleaner")
    val images: List<Image>? = ArrayList(),

    @OneToOne
    val user: User?
)
