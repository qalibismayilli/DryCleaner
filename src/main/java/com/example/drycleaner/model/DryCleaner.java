package com.example.drycleaner.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "dry_cleaners")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DryCleaner {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "dry_cleaner_id")
    String dryCleanerId;

    @Column(name = "created_date")
    @CreationTimestamp
    LocalDateTime createdDate;

    @Column(name = "updated_date")
    @UpdateTimestamp
    LocalDateTime updatedDate;

    @Column(name = "dry_cleaner_name")
    String dryCleanerName;

    String location;

    @Column(name = "description")
    String description;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dryCleaner")
    List<Service> services;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dryCleaner")
    List<Image> images;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "user_id")
    User user;
}
