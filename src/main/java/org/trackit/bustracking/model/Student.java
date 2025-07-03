package org.trackit.bustracking.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
public class Student {
    @Id
    private String registrationNo;
    private String name;
    private Boolean isComingToday=false;
    @Column(unique = true)
    private String username;
    private String password;

    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String phone;

    @ManyToOne
    @JoinColumn(name = "bus_id", nullable = true)
    @JsonBackReference
    private Bus assignedBus;
    private String pickupLocation;

    @Column(nullable = true)
    private String profilePhotoPath;

    @Column(nullable = true)
    private double latitude;
    @Column(nullable = true)
    private double longitude;
}
