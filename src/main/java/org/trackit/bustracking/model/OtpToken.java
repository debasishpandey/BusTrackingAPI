package org.trackit.bustracking.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class OtpToken {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String email;
    private String otp;

    private LocalDateTime createdAt;

    // constructor, getters, setters
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}
