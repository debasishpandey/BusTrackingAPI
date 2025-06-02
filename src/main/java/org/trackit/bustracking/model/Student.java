package org.trackit.bustracking.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {
    @Id
    private String registrationNo;
    private String name;
    private Boolean isComingToday;

    private String username;
    private String password;

    @ManyToOne
    @JoinColumn(name = "bus_id", nullable = true)
    private Bus assignedBus;
    private String pickupLocation;

    private String profilePhotoPath;
}
