package com.example.drycleaner.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "services")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Service {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "service_id")
    String serviceId;

    @Column(name = "created_date")
    @CreationTimestamp
    LocalDateTime createdDate;

    @Column(name = "updated_date")
    @UpdateTimestamp
    LocalDateTime updatedDate;

    @Column(name = "service_name")
    @Enumerated(EnumType.STRING)
    ServiceName serviceName;

    @Column(name = "price")
    Integer price;

    @Column(name = "discount")
    Integer discount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "dry_cleaner_id")
    DryCleaner dryCleaner;
}
