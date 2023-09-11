package com.Java_Programming.e_commerce_backend.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "audit_log")
public class AuditLog {

    @Id
    private String id;
    private String userId;
    private String operation;
    private String entityName;
    private String entityId;
    private Date date;
}