package com.reserveall.drycleaner.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.OneToOne
import jakarta.persistence.Table
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", nullable = false, updatable = false)
    val id: String,

    @Column(name = "created_date")
    @CreationTimestamp
    val createdDate: LocalDateTime? = null,

    @Column(name = "updated_date")
    @UpdateTimestamp
    val updatedDate: LocalDateTime? = null,

    @Column(name = "username")
    val username: String,

    @Column(name = "password")
    val password: String,

    @Column(name = "role")
    val role: Role?,

    @Column(name = "email")
    val email: String?,

    @OneToOne(mappedBy = "user")
    val dryCleaner: DryCleaner?

)
