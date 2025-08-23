package com.example.drycleaner.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Table(name = "services")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Service {
    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "service_id",columnDefinition = "uuid", nullable = false, updatable = false)
    UUID serviceId;

    @Column(name = "created_date")
    @CreationTimestamp
    LocalDateTime createdDate;

    @Column(name = "updated_date")
    @UpdateTimestamp
    LocalDateTime updatedDate;

    @Column(name = "service_name")
    String serviceName;

    Double price;
    Double discount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "dry_cleaner_id")
    DryCleaner dryCleaner;

    @Column(name = "is_active")
    Integer isActive;

    @Column(name = "is_deleted")
    Boolean isDeleted;
}
