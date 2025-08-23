package com.example.drycleaner.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class File {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "file_id", columnDefinition = "uuid", nullable = false, updatable = false)
    String fileId;


}
