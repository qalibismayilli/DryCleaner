package com.reserveall.drycleaner.model

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Entity
@Table(name = "services")
data class Service @JvmOverloads constructor(
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

    @Column(name = "service_name")
    val serviceName: ServiceName?,

    @Column(name = "price")
    val price: Int?,

    @Column(name = "discount")
    val discountRate: Int? = 0 ,

    @ManyToOne(fetch = FetchType.LAZY)
    val dryCleaner: DryCleaner? = null
)
