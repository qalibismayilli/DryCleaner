package com.reserveall.drycleaner.model

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Entity
@Table(name = "images")
data class Image(
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    val id: String?,

    @Column(name = "created_date")
    @CreationTimestamp
    val createdDate: LocalDateTime?,

    @Column(name = "updated_date")
    @UpdateTimestamp
    val updatedDate: LocalDateTime?,

    @Column(name = "image_url")
    val imageUrl: String?,

    @ManyToOne
    @JoinColumn(name = "dry_cleaner_id", referencedColumnName = "id")
    val dryCleaner: DryCleaner?
)
